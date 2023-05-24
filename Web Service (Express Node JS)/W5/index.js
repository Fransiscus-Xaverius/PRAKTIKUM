const express = require("express")
const Joi = require('joi').extend(require('@joi/date'));
const app = express();
const sequelize = require("sequelize")
const port = 3000;
const sql = require("mysql2");
const axios = require("axios");

app.use(express.urlencoded({extended: true}));

const conn = new sequelize("t5_6955", "root", "",{
    host: "localhost",
    port: 3306,
    dialect: "mysql"
});

async function userExists(username){
    let foo = await conn.query(
        `select COUNT(*) as count from users where username = :username`,{
            replacements:{
                username:username
            }
        }
    )
    let count =  foo[0][0].count;
    if(count==0) return false;
    return true;
}

async function isUnique(username){
    let foo = await conn.query(
        `select COUNT(*) as count from users where username = :username`,{
            replacements:{
                username:username
            }
        }
    )
    let count =  foo[0][0].count;
    if(count==0) return true;
    throw new Error("Username tersebut sudah digunakan.");
}

async function UserExists(username){
    let [exist, metadata] = await conn.query(
        `select * from users where username = :username`,
        {
            replacements:{
                username: username
            }
        }
    )
    console.log(exist);
    if(exist.length>0){
        return true;
    }
    else{
        throw new Error("Username tidak terdaftar.");
    }
}

async function getDeckCount(){
    let count = await conn.query(
        `Select COUNT(*) as count from decks`
    )

    return count[0][0].count;
}

async function generateDeckID(){
    let id = "D";
    let count = await getDeckCount();
    count++;
    let satuan = parseInt(count%10);
    let puluhan = parseInt((count/10)%10);
    let ratusan = parseInt(count/100);

    let generateID = id+ratusan+puluhan+satuan;
    return generateID;
}

async function getUserDetails(username){
    let [result, metadata] = await conn.query(
        `select * from users where username = :username`,
        {
            replacements:{
                username:username
            }
        }
    )

    return result[0];
}

async function getAllDecksOfUser(username){
    let [result, metadata] = await conn.query(
        `select * from decks where username = :username`,{
            replacements:{
                username:username
            }
        }
    )
    return result[0];
}

async function deckExists(id_deck){
    let foo = await conn.query(
        `select COUNT(*) as count from decks where id_deck = :id_deck`,{
            replacements:{
                id_deck:id_deck
            }
        }
    )
    let count =  foo[0][0].count;
    if(count==0) return false;
    return true;   
}

async function cardExistsInDeck(id_deck, id_card){
    let foo = await conn.query(
        `select COUNT(*) as count from cards where id_deck = :id_deck and id_card = :id_card`,{
            replacements:{
                id_deck:id_deck,
                id_card:id_card
            }
        }
    )
    let count =  foo[0][0].count;
    if(count==0) return false;
    return true;   
}

async function getDeckDetails(id_deck){
    let foo = await conn.query(
        `select * from decks where id_deck = :id_deck`,{
            replacements:{
                id_deck:id_deck
            }
        }
    )
    return foo[0][0];
}

async function getDuplicateCardCount(id_card, id_deck){
    let foo = await conn.query(
        `select count(*) as COUNT from cards where id_deck = :id_deck and id_card = :id_card`,{
            replacements:{
                id_deck:id_deck,
                id_card:id_card
            }
        }
    )
    return foo[0][0].COUNT;
}

async function addCard(id_deck,id_card,card_name,card_type){
    let foo = await conn.query(
        `insert into cards(id_deck, id_card, card_name, card_type) values(:id_deck, :id_card, :card_name, :card_type)`,{
            replacements:{
                id_deck:id_deck,
                id_card:id_card,
                card_name:card_name,
                card_type:card_type
            }
        }
    )
}

async function deleteCard(id_card,id_deck){
    let foo = await conn.query(
        `delete from cards where id_card = :id_card and id_deck = :id_deck limit 1`,
        {
            replacements:{
                id_card:id_card,
                id_deck:id_deck
            }
        }
    )
}

async function getCardName(id_card,id_deck){
    let foo = await conn.query(
        `select card_name from cards where id_deck = :id_deck and id_card = :id_card`,
        {
            replacements:{
                id_card:id_card,
                id_deck:id_deck
            }
        }
    )
    console.log(foo[0][0].card_name);
    return foo[0][0].card_name;
}

//no 1
app.post("/api/users", async(req,res)=>{
    const schema = Joi.object({
        name: Joi.string().required().min(1),
        username: Joi.string().required().external(isUnique).min(1)
    })

    try {
        await schema.validateAsync(req.body);
    } catch (error) {
        if(!req.body.name||!req.body.username){
            return res.status(400).send({
                msg: "Semua field wajib diisi"
            })
        }
        else{
            console.log(error.toString())
            return res.status(400).send({
                msg:"User tidak boleh kembar!"
            })
        }
    }    

    let [result,metadata] = await conn.query(
        `insert into users(username, name) values(:username, :name)`,{
            replacements:{
                username: req.body.username,
                name: req.body.name
            }
        }
    )

    return res.status(201).send({
        name: req.body.name,
        username: req.body.username
    })

})

//no 2
app.get("/api/cards", async(req,res)=>{
    let url = "https://db.ygoprodeck.com/api/v7/cardinfo.php";

    const schema = Joi.object({
        name: Joi.string().required(),
        type: Joi.string()
    })

    try {
        await schema.validateAsync(req.query);
    } catch (error) {
        if(!req.query.name){
            return res.status(400).send({msg:"Card name harus diberikan"});
        }
        return res.status(400).send(error.toString());
    }

    if(req.query.type){
        url+=`?fname=${req.query.name}&type=${req.query.type} Card`;
    }
    else{
        url+=`?name=${req.query.name}`;
    }

    let getdata = await axios.get(url);

    let hasil = getdata.data.data;

    console.log(hasil);

    let end = [];

    hasil.forEach(element => {
        let temp = {
            id: element.id,
            name: element.name,
            type: element.type,
            race: element.race
        };
        end.push(temp);
    });

    return res.status(200).send(end);

})

//No 3
app.get("/api/cards/:id_card", async(req,res)=>{
    let id = req.params.id_card;
    if(id){
        if(id>0){
            let url = "https://db.ygoprodeck.com/api/v7/cardinfo.php";
            url+=`?id=${id}`;
            let gethasil;
            try {
                gethasil = await axios.get(url);
            } catch (error) {
                return res.status(400).send({msg:"id_card invalid"})
            }
            let hasil = gethasil.data.data[0];
            let temp = {
                name: hasil.name,
                type: hasil.type,
                frameType: hasil.frameType,
                desc: hasil.desc,
                race: hasil.race,
                archetype: hasil.archetype
            }
            return res.status(200).send(temp);
        }
        else{
            return res.status(400).send({
                msg:"id_card invalid"
            })
        }
    }
    else{
        return res.status(400).send("ID tidak diberikan.")
    }
})

//No 4
app.post("/api/decks", async(req,res)=>{
    const schema = Joi.object({
        username: Joi.string().required().external(UserExists).min(1),
        deck_name: Joi.string().required().min(1)
    })

    try {
        await schema.validateAsync(req.body);
    } catch (error) {
        if(!req.body.username||!req.body.deck_name||req.body.username.length<=0||req.body.deck_name<=0){
            return res.status(400).send({msg:"Semua field wajib diisi"});
        }
        else{
            return res.status(400).send({msg:"Username tidak terdaftar"});
        }
    }

    let id = await generateDeckID();

    let [result,metadata] = await conn.query(
        `insert into decks(id_deck, deck_name, username) values(:id_deck, :deck_name, :username)`,
        {
            replacements:{
                id_deck:id,
                deck_name: req.body.deck_name,
                username: req.body.username
            }
        }
    )

    return res.status(201).send({
        id_deck: id,
        deck_name: req.body.deck_name
    })

})

//No 5
app.post("/api/decks/:id_deck/cards", async(req,res)=>{
    let id = req.params.id_deck;
    let username = req.body.username;
    let id_card = req.body.id_card;
    let qty = req.body.qty;
    if(id&&username&&id_card&&qty){
        if(id.length===4&&username.length>0&&id_card.length>0&&id_card.length>0&&parseInt(qty)>0&&parseInt(qty)<4){
            let deckex = await deckExists(id);
            if(deckex){
                let deck = await getDeckDetails(id);
                if(deck.username==username){
                    let count = parseInt(await getDuplicateCardCount(id_card,id));
                    count+=parseInt(qty);
                    console.log(count);
                    if(count>3){
                        return res.status(400).send({msg:"Jumlah kartu tersebut sudah melebihi batas pada deck ini."})
                    }
                    else{
                        let url = "https://db.ygoprodeck.com/api/v7/cardinfo.php";
                        url+=`?id=${id_card}`;
                        let gethasil;
                        try {
                            gethasil = await axios.get(url);
                        } catch (error) {
                            return res.status(400).send({msg:"id_card invalid"})
                        }
                        let hasil = gethasil.data.data[0];
                        for (let index = 0; index < qty; index++) {
                            await addCard(id, id_card, hasil.name, hasil.type);
                        }
                        return res.status(201).send({
                            msg:`Berhasil menambahkan kartu '${hasil.name} sebanyak ${qty} kartu'`
                        }); 
                    }
                }
                else{
                    return res.status(400).send({msg:"User tersebut bukan pemilik deck."})
                }
            }
            else{
                return res.status(400).send("Deck tidak ditemukan");
            }
        }
        else if(qty<=0||qty>3){
            return res.status(400).send({msg:"qty invalid"})
        }
    }
    else{
        return res.status(400).send({msg:"Semua field harus diisi."})
    }
})

//No. 6
app.delete("/api/decks/:id_deck/cards/:id_card", async(req,res)=>{
    let id_deck = req.params.id_deck;
    let id_card = req.params.id_card;
    let username = req.body.username;

    if(id_deck&&id_card&&username){
        if(id_deck.length>0&&id_card.length>0&&username.length>0){
            let deckex = await deckExists(id_deck);
            if(deckex){
                let deck = await getDeckDetails(id_deck);
                if(deck.username===username){
                    let cardInDeck = await cardExistsInDeck(id_deck,id_card);
                    if(cardInDeck){
                        let cardDetails = await getCardName(id_card,id_deck);
                        await deleteCard(id_card,id_deck);
                        return res.status(201).send({msg:`Berhasil menghapus kartu '${cardDetails}' dari dalam deck`})
                    }
                    else{
                        return res.status(400).send({msg:"Kartu tidak terdapat didalam deck."})
                    }
                }
                else{
                    return res.status(400).send({msg:"User tersebut bukan pemilik deck"});
                }
            }
            else{
                return res.status(400).send({msg:"Deck tidak terdaftar."})
            }
        }
        else{
            return res.status(400).send({msg:"Semua field wajib diisi"});
        }
    }
    else{
        return res.status(400).send({msg:"Semua field wajib diisi"});
    }
})

//No. 8
app.get("/api/users/:username", async(req,res)=>{
    let username = req.params.username;
    if(username&&username.length>0){
        let userExist = await userExists(username);
        if(userExist){
            let dataUser = await getUserDetails(username);
            let decks = await getAllDecksOfUser(username);
            let temp = {
                name: dataUser.name,
                username: dataUser.username,
                decks :decks
            }
            return res.status(200).send(temp);    
        }
        else{
            return res.status(400).send({msg:"User tidak ditemukan"})
        }
    }
    else{
        return res.status(400).send({msg:"Field Username tidak diisi"})
    }
})

const initApp = async () =>{
    console.log("testing db connection");
    try {
        await conn.authenticate();
        console.log("Successfully connected to db");
        app.listen(port, ()=>
            console.log(`App listening on port ${port}!`)
        );
    } catch (error) {
        console.error("Failed to connect to database : ", error.original);
    }
}

initApp();