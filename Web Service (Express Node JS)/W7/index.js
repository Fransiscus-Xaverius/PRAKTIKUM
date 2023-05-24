const express = require("express");
const app = express();
const sequelize = require("sequelize")
const port = 3000;
const sql = require("mysql2");

app.use(express.json());
app.use(express.urlencoded({extended: true}));

const conn = new sequelize("t7_6955", "root", "",{
    host: "localhost",
    port: 3306,
    dialect: "mysql"
});

function randomString(length, chars) {
    var result = '';
    for (var i = length; i > 0; --i) result += chars[Math.floor(Math.random() * chars.length)];
    return result;
}

async function tokenExists(token){
    let foo = await conn.query(
        `select COUNT(*) as count from users where token = :token`,{
            replacements:{
                token:token
            }
        }
    )
    let count =  foo[0][0].count;
    if(count==0) return false;
    return true;
}

async function usernameExists(username){
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

async function getUserCount(){
    let count = await conn.query(
        `Select COUNT(*) as count from users`
    )

    return count[0][0].count;
}

async function getFoodCount(){
    let count = await conn.query(
        `Select COUNT(*) as count from foods`
    )

    return count[0][0].count;
}

async function generateFoodID(){
    let id = "F";
    let count = await getFoodCount();
    count++;
    let satuan = parseInt(count%10);
    let puluhan = parseInt((count/10)%10);
    let ratusan = parseInt(count/100);

    let generateID = id+ratusan+puluhan+satuan;
    return generateID;
}

async function generateUserID(){
    let id = "U";
    let count = await getUserCount();
    count++;
    let satuan = parseInt(count%10);
    let puluhan = parseInt((count/10)%10);
    let ratusan = parseInt(count/100);

    let generateID = id+ratusan+puluhan+satuan;
    return generateID;
}

async function createNewUser(id,username,name,password,token){
    let foo = await conn.query(
        `insert into users(id,username,name,password,token, saldo, api_hit) values('${id}','${username}','${name}','${password}','${token}',0,0)`
    )
}

async function createNewFood(id_makanan,nama_makanan, deskripsi_makanan, bahan_utama, harga, asal_makanan, pembuat){
    let foo = await conn.query(
        `insert into foods(id_makanan,nama_makanan, deskripsi_makanan, bahan_utama, harga, asal_makanan, pembuat) values('${id_makanan}','${nama_makanan}','${deskripsi_makanan}','${bahan_utama}','${harga}','${asal_makanan}','${pembuat}')`
    )
}

async function getUserData(username){
    let [result,metadata] = await conn.query(
        `select * from users where username=:username`,{
            replacements:{
                username:username
            }
        }
    )
    return result[0];
}

async function authUserData(token){
    let [result,metadata] = await conn.query(
        `select * from users where token=:token`,{
            replacements:{
                token:token
            }
        }
    )
    return result[0];
}

async function topupSaldo(saldo,username){
    let userdata = await getUserData(username);
    let curSaldo = parseInt(userdata.saldo);
    curSaldo+=parseInt(saldo);
    let foo = await conn.query(
        `UPDATE users set saldo = :saldo where username = :username`,{
            replacements:{
                saldo:curSaldo,
                username:username
            }
        }
    )
    return curSaldo;
}

async function authenticateUser(username,password){
    let userdata = await getUserData(username);
    if(userdata.password==password){
        return true;
    }
    return false;
}

async function rechargehit(api_hit, username){
    let userdata = await getUserData(username);
    let saldo = parseInt(api_hit)*2000;
    let curSaldo = parseInt(userdata.saldo);
    curSaldo-=parseInt(saldo);
    let curApiHit = userdata.api_hit;
    curApiHit+=parseInt(api_hit);
    let foo = await conn.query(
        `UPDATE users set saldo = :saldo , api_hit = :api_hit where username = :username`,{
            replacements:{
                saldo:curSaldo,
                username:username,
                api_hit: curApiHit
            }
        }
    )
    return curSaldo;
}

async function useHit(hit, token){
    let userdata = await authUserData(token);
    let curHit = userdata.api_hit;
    curHit-=hit;
    let foo = await conn.query(
        `UPDATE users set api_hit = :api_hit where token = :token`,{
            replacements:{
                api_hit: curHit,
                token:token
            }
        }
    )
}

async function foodExists(id){
    let foo = await conn.query(
        `select COUNT(*) as count from foods where id_makanan = :id_makanan`,{
            replacements:{
                id_makanan:id
            }
        }
    )
    let count =  foo[0][0].count;
    if(count==0) return false;
    return true;
}

async function getFoodDetails(id){
    let [result,metadata] = await conn.query(
        `select * from foods where id_makanan = :id_makanan`,{
            replacements:{
                id_makanan:id
            }
        }
    )
    return result[0];
}

async function getFoods(query){
    let [result,metadata] = await conn.query(
        query
    )
    return result;
}

//no 1
app.post("/api/accounts",async (req,res)=>{
    let {username, nama, password} = req.body;
    let newToken = "";
    if(username&&nama&&password){
        if(await usernameExists(username)){
            return res.status(400).send({
                msg:"username tersebut sudah digunakan"
            });
        }
        else{
            let generating = true;
            while(generating){
                newToken = randomString(7, '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ');
                generating = await tokenExists(newToken);
            }
            let id = await generateUserID();
            await createNewUser(id, username,nama, password,newToken);
            return res.status(201).send({
                id:id,
                username:username,
                nama:nama,
                password:password,
                api_key:newToken,
                saldo:0,
                api_hit:0
            });
        }
    }
    else{
        return res.status(400).send({msg:"Semua field harus diisi"})
    }
})

//no 2
app.put("/api/accounts/topup", async(req,res)=>{
    let {username, password, topup} = req.body;
    if(username, password, topup){
        if(await usernameExists(username)){
            if(parseInt(topup)>=10000){
                if(await authenticateUser(username,password)){
                    let saldo = await topupSaldo(topup,username);
                    return res.status(200).send({
                        message:"Berhasil topup",
                        username:username,
                        saldo:saldo
                    })
                }
                else{
                    return res.status(403).send({
                        msg:"Username/password salah. (Data Login tidak benar)"
                    })
                }
            }
            else{
                return res.status(400).send({
                    message:"Minimal topup adalah Rp.10000"
                })
            }
        }
        else{
            return res.status(400).send({
                msg:"Username tidak terdaftar"
            })
        }
    }
    else{
        return res.status(400).send({msg:"Semua field harus diisi"})
    }
})

//no 3
app.put("/api/accounts/recharge", async (req,res)=>{
    let {username, password, kuota_api_hit} = req.body;
    if(username&&password&&kuota_api_hit){
        if(parseInt(kuota_api_hit)>=5){
            if(await usernameExists(username)){
                if(await authenticateUser(username,password)){
                    let userdata = await getUserData(username);
                    if((parseInt(kuota_api_hit)*2000)>userdata.saldo){
                        return res.status(400).send(
                            {
                                message:"Saldo tidak mencukupi"
                            }
                        )
                    }
                    else{
                        let saldo = await rechargehit(kuota_api_hit, username);
                        userdata = await getUserData(username);
                        return res.status(200).send({
                            message:"berhasil menambahkan kuota api_hit",
                            username:username,
                            saldo:saldo,
                            api_hit: userdata.api_hit
                        })
                    }
                }
                else{
                    return res.status(403).send({
                        msg:"Username/password salah. (Data Login tidak benar)"
                    })
                }
            }
            else{
                return res.status(400).send({
                    msg:"Username tidak terdaftar"
                })
            }
        }
        else{
            return res.status(400).send({message: "Minimal topup/recharge 10000 (5 kuota hit)"})
        }
    }
    else{
        return res.status(400).send({msg:"Semua field harus diisi"})
    }
})

//no 4
app.post("/api/foods", async(req,res)=>{
    let {nama, deskripsi, bahan_utama, harga, asal_makanan} = req.body;
    let token = req.header('x-auth-token');
    if(token){
        if(nama&&deskripsi&&bahan_utama&&harga&&asal_makanan){
            if(await tokenExists(token)){
                if(parseInt(harga)<5000){
                    return res.status(400).send({
                        message:"harga minimal 5000"
                    })
                }
                else{
                    let userdata = await authUserData(token);
                    let foodID = await generateFoodID();
                    await createNewFood(foodID, nama,deskripsi, bahan_utama, harga, asal_makanan,userdata.username);
                    return res.status(201).send({
                        id_makanan:foodID,
                        nama:nama,
                        deskripsi:deskripsi,
                        bahan_utama:bahan_utama,
                        harga:harga,
                        asal_makanan: asal_makanan,
                        pembuat: userdata.username
                    })
                }
            }
            else{
                return res.status(403).send({
                    message:"Unauthorized API Token."
                })
            }
        }
        else{
            return res.status(400).send({msg:"Semua field harus diisi"})
        }
    }
    else{
        return res.status(400).send({
            message:"Missing x-auth-token(api token key)"
        })
    }
})

//no 5
app.get("/api/foods", async (req,res)=>{
    let token = req.header('x-auth-token');
    let {min_harga, max_harga, asal, bahan_utama} = req.query;
    if(token){
        if(await tokenExists(token)){
            let and = false;
            let query = `select id_makanan as id, nama_makanan as nama, harga, asal_makanan as asal from foods`;
            if(min_harga||max_harga||asal||bahan_utama){
                query+=' where '
                if(min_harga){
                    query+=`harga >= ${min_harga}`
                    and = true;
                }
                if(max_harga){
                    let temp = ""
                    if(and){
                        temp+=" and "
                    }
                    and = true;
                    temp+=`harga <= ${max_harga}`;
                    query+=temp;
                }
                if(asal){
                    console.log("asal");
                    let temp = ""
                    if(and){
                        temp+=" and "
                    }
                    and = true;
                    temp+=`asal_makanan like '%${asal}%'`;
                    query+=temp;
                }
                if(bahan_utama){
                    let temp = ""
                    if(and){
                        temp+=" and "
                    }
                    and = true;
                    temp+=`bahan_utama like '%${bahan_utama}%'`;
                    query+=temp;
                }
            }

            await useHit(5,token);
            let result = await getFoods(query);
            console.log(result);
            return res.status(200).send({
                body:result
            })

        }
        else{
            return res.status(403).send({
                message:"Unauthorized API Token."
            })
        }
    }
    else{
        return res.status(400).send({
            message:"Missing x-auth-token(api token key)"
        })
    }
})

//no 6
app.get("/api/foods/:id_food", async (req,res)=>{
    let id_food = req.params.id_food;
    let token = req.header('x-auth-token');
    if(token){
        let userdata = await authUserData(token);
        if(await tokenExists(token)){
            if(id_food){
                if(await foodExists(id_food)){
                    if(userdata.api_hit>=3){
                        let foodData = await getFoodDetails(id_food);
                        await useHit(3, token);
                        return res.status(200).send({
                            id:id_food,
                            nama:foodData.nama_makanan,
                            deskripsi:foodData.deskripsi,
                            bahan_utama:foodData.bahan_utama,
                            harga:foodData.harga,
                            pembuat: foodData.pembuat
                        })
                    }
                    else{
                        return res.status(400).send({
                            message:"API Hit tidak mencukupi. (minimal 3)"
                        })
                    }
                }
                else{
                    return res.status(400).send({
                        message:"id_food tidak terdaftar"
                    })
                }
            }
            else{
                return res.status(400).send({
                    message: "id_food tidak diberikan"
                })
            }
        }
        else{
            return res.status(403).send({
                message:"Unauthorized API Token."
            })
        }
    }
    else{
        return res.status(400).send({
            message:"Missing x-auth-token(api token key)"
        })
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