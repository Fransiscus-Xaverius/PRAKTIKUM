
const express = require('express');
const app = express();
const sequelize = require("./db");
const cors = require('cors');
app.use(cors())

async function userExists(mail,username){
    console.log("userExist")
    let foo = await sequelize.query(
        `select COUNT(*) as count from users where email=:email or username=:username`,{
            replacements:{
                email:mail,
                username:username
            }
        }
    )
    let count =  foo[0][0].count;
    if(count==0) return false;
    return true;
}

async function getAmount(username){
    console.log("userExist")
    let foo = await sequelize.query(
        `select COUNT(*) as count from stories where username=:username and active=true`,{
            replacements:{
                username:username
            }
        }
    )
    let count =  foo[0][0].count;
    return count;
}

async function validateLogin(email,password){
    let foo = await sequelize.query(
        `select COUNT(*) as count from users where email=:email and password=:password`,{
            replacements:{
                email:email,
                password:password
            }
        }
    )
    let count =  foo[0][0].count;
    if(count==0) return false;
    return true;
}

async function getUser(email,password){
    let foo = await sequelize.query(
        `select * from users where email=:email and password=:password`,{
            replacements:{
                email:email,
                password:password
            }
        }
    )
    return foo[0][0];
}

app.post('/login', async (req, res) => {
    const {email,password} = req.query
    
    const valid = await validateLogin(email,password);
    if(!valid) return res.status(401).send({"msg":"Email atau password salah"});

    const user = await getUser(email,password);
    return res.status(200).send({"msg":"Login berhasil", "user":user});
});

app.put('/update', async (req, res) => {
    const {email, password, nama,username} = req.query
    if(await userExists(email,username)){
        let foo = await sequelize.query(
            `UPDATE users SET password=:password, nama=:nama, email=:email WHERE username=:username`,{
                replacements:{
                    username:username,
                    email:email,
                    password:password,
                    nama:nama
                }
            }
        )
        if(foo) return res.status(200).send({"msg":"User berhasil diupdate", "email":email, "nama":nama, "password":password});
        return res.status(500).send({"msg":"Internal server error"});
    }
    
        else{
            res.status(404).send({"msg":"User tidak ditemukan"});
        }
});

app.post('/register', async (req, res) => {
    const {email, password, nama,username} = req.query

    if(await userExists(email,username)){
        res.status(409).send({"msg":"Email/Username sudah terdaftar"});
    }

    else{
        let foo = await sequelize.query(
            `INSERT into users(email, password, nama, username) VALUES (:email, :password, :nama, :username)`,{
                replacements:{
                    email:email,
                    password:password,
                    nama:nama,
                    username:username
                }
            }
        )
        if(foo) return res.status(201).send({"msg":"User berhasil didaftarkan", "email":email, "nama":nama});
        return res.status(500).send({"msg":"Internal server error"});
    }

});

app.post("/stories", async (req, res) => {
    const {username} = req.query

    let amount = await getAmount(username);

    let foo = await sequelize.query(
        `INSERT into stories(nama, poster, username, active) VALUES (:nama, :poster, :username, :active)`,{
            replacements:{
                nama:`Untitled #${amount+1}`,
                poster:"",
                username:username,
                active:true
            }
        }
    )
    console.log(foo);
    if(foo) return res.status(201).send({"msg":"Story berhasil ditambahkan", "id":foo[0]});
    return res.status(500).send({"msg":"Internal server error"});
});

app.get('/stories/all', async (req, res) => {
    const {username} = req.query

    let foo = await sequelize.query(
        `select * from stories where username=:username and active=:active`,{
            replacements:{
                username:username,
                active:true
            }
        }
    )
    console.log(foo);
    return res.status(200).send({"msg":"Stories berhasil didapatkan", "stories":foo[0]});
});

app.get('/stories', async (req, res) => {
    const {id} = req.query

    let foo = await sequelize.query(
        `select * from stories where id=:id`,{
            replacements:{
                id:id
            }
        }
    )
    console.log(foo[0]);
    return res.status(200).send({"msg":"Stories berhasil didapatkan", "stories":foo[0]});
});

app.put('/stories/updateimg', async (req, res) => {
    const {id, poster} = req.query

    let foo = await sequelize.query(
        `UPDATE stories SET  poster=:poster WHERE id=:id`,{
            replacements:{
                id:id,
                poster:poster
            }
        }
    )
    if(foo) return res.status(200).send({"msg":"Story berhasil diupdate"});
    return res.status(500).send({"msg":"Internal server error"});
});

app.put('/stories/updatenama', async (req, res) => {
    const {id, nama} = req.query

    let foo = await sequelize.query(
        `UPDATE stories SET  nama=:nama WHERE id=:id`,{
            replacements:{
                id:id,
                nama:nama
            }
        }
    )
    if(foo) return res.status(200).send({"msg":"Story berhasil diupdate"});
    return res.status(500).send({"msg":"Internal server error"});

});

app.delete('/stories', async (req, res) => {
    const {id} = req.query

    let foo = await sequelize.query(
        `UPDATE stories SET active=:active WHERE id=:id`,{
            replacements:{
                id:id,
                active:false
            }
        }
    )
    if(foo) return res.status(200).send({"msg":"Story berhasil dihapus"});
    return res.status(500).send({"msg":"Internal server error"});
});

app.listen(3000, () => {
  console.log('Server is running on port 3000');
});
