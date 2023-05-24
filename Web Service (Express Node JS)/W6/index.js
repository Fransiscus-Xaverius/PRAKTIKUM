const express = require("express");
const app = express();
const sequelize = require("sequelize")
const port = 3000;
const sql = require("mysql2");
const jwt = require("jsonwebtoken");
const JWT_KEY = 'SonSeungWan';

app.use(express.json());
app.use(express.urlencoded({extended: true}));

const conn = new sequelize("t6_6955", "root", "",{
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

async function RoleExists(role_id){
    let foo = await conn.query(
        `select COUNT(*) as count from roles where role_id = :role_id`,{
            replacements:{
                role_id:role_id
            }
        }
    )
    let count =  foo[0][0].count;
    if(count==0) return false;
    return true;
}

async function codeExists(code){
    let foo = await conn.query(
        `select COUNT(*) as count from servers where join_code = :join_code`,{
            replacements:{
                join_code:code
            }
        }
    )
    let count =  foo[0][0].count;
    if(count==0) return false;
    return true;
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

async function getRoleDetails(role_id){
    let [result, metadata] = await conn.query(
        `select * from roles where role_id = :role_id`,
        {
            replacements:{
                role_id:role_id
            }
        }
    )
    return result[0];
}

async function getServerCount(){
    let count = await conn.query(
        `Select COUNT(*) as count from servers`
    )

    return count[0][0].count;
}

async function getRoleCount(ID_server){
    let count = await conn.query(
        `Select COUNT(*) as count from roles where ID_server = :ID_server`,{
            replacements:{
                ID_server:ID_server
            }
        }
    )
    return count[0][0].count;
}

async function getChannelCount(ID_server){
    let count = await conn.query(
        `Select COUNT(*) as count from text_channels where ID_server = :ID_server`,{
            replacements:{
                ID_server:ID_server
            }
        }
    )
    return count[0][0].count;
}

async function generateServerID(){
    let id = "SR";
    let count = await getServerCount();
    count++;
    let satuan = parseInt(count%10);
    let puluhan = parseInt((count/10)%10);
    let ratusan = parseInt(count/100);

    let generateID = id+ratusan+puluhan+satuan;
    return generateID;
}

function randomString(length, chars) {
    var result = '';
    for (var i = length; i > 0; --i) result += chars[Math.floor(Math.random() * chars.length)];
    return result;
}

async function getServerFromJoinCode(join_code){
    let [result, metadata] = await conn.query(
        `select * from servers where join_code = :join_code`,
        {
            replacements:{
                join_code:join_code
            }
        }
    )
    return result[0];
}

async function isUserBanned(username,ID_server){
    let foo = await conn.query(
        `select COUNT(*) as count from ban where username = :username and ID_server = :ID_server`,{
            replacements:{
                username:username,
                ID_server:ID_server
            }
        }
    )
    let count =  foo[0][0].count;
    if(count==0) return false;
    return true;
}

async function userAlreadyJoined(username,ID_server){
    let foo = await conn.query(
        `select COUNT(*) as count from user_roles where username = :username and ID_server = '${ID_server}'`,{
            replacements:{
                username:username,
            }
        }
    )
    let count =  foo[0][0].count;
    if(count==0) return false;
    return true;
}

async function getUserRole(username, ID_server){
    let foo = await conn.query(
        `select * from user_roles where username =:username and ID_server =:ID_server`,{
            replacements:{
                username: username,
                ID_server:ID_server
            }
        }
    )
    return foo[0][0];
}

async function generateRoleID(ID_server){
    let ID = ID_server;
    let count = await getRoleCount(ID_server);
    count++;
    let satuan = parseInt(count%10);
    let puluhan = parseInt((count/10)%10);
    let ratusan = parseInt(count/100);
    let generatedID = ID+"RL"+ratusan+puluhan+satuan;
    return generatedID;
}

async function generateChannelID(ID_server){
    let ID = ID_server;
    let count = await getChannelCount(ID_server);
    count++;
    let satuan = parseInt(count%10);
    let puluhan = parseInt((count/10)%10);
    let ratusan = parseInt(count/100);
    let generatedID = ID+"TC"+ratusan+puluhan+satuan;
    return generatedID;
}

async function isServerRole(ID_server, role_id){
    let foo = await conn.query(
        `select COUNT(*) as count from roles where role_id = :role_id and ID_server = :ID_server`,{
            replacements:{
                role_id:role_id,
                ID_server:ID_server
            }
        }
    )
    let count =  foo[0][0].count;
    if(count==0) return false;
    return true;
}

async function userHasRole(username, role_id){
    let foo = await conn.query(
        `select COUNT(*) as count from user_roles where username = :username and role_id = :role_id`,{
            replacements:{
                username:username,
                role_id:role_id
            }
        }
    )
    let count =  foo[0][0].count;
    if(count==0) return false;
    return true;
}

async function removeUserRole(username,role_id,ID_server){
    let foo = await conn.query(
        `delete from user_roles where username =:username and role_id =:role_id and ID_server=:ID_server`,{
            replacements:{
                username:username,
                role_id:role_id,
                ID_server:ID_server
            }
        }
    )
}

async function giveUserRole(username, ID_server, role_id, role_name){
    let foo = await conn.query(
        `insert into user_roles(username, ID_server, role_id, role_name) values(:username, :ID_server, :role_id, :role_name)`,{
            replacements:{
                username:username,
                ID_server:ID_server,
                role_id:role_id,
                role_name:role_name
            }
        }
    )
}

async function kickUser(username, ID_server){
    let foo = await conn.query(
        `delete from user_roles where username =:username and ID_server=:ID_server`,{
            replacements:{
                username:username,
                ID_server:ID_server
            }
        }
    )
}

async function banUser(username, ID_server){
    let foo = await conn.query(
        `insert into ban(username, ID_server) values(:username, :ID_server)`,{
            replacements:{
                username:username,
                ID_server:ID_server,
            }
        }
    )
}

async function getUserRoles(username){
    let [result,metadata] = await conn.query(
        `select * from user_roles where username = '${username}'`
    )
    let allRoles = [];
    for (let index = 0; index < result.length; index++) {
        allRoles.push(result[index].role_id);
    }
    console.log(allRoles);
    return allRoles;
}

async function getAllAllowedRoles(text_channel_id){
    let [result,metadata] = await conn.query(
        `select * from allowed_roles where text_channel_id = '${text_channel_id}'`
    )
    let allRoles = [];
    for (let index = 0; index < result.length; index++) {
        allRoles.push(result[index].role_id);
    }
    console.log(allRoles);
    return allRoles;
}

async function userCanSendMessage(username, text_channel_id){
    let allAllowed = await getAllAllowedRoles(text_channel_id);
    let userRoles = await getUserRoles(username);
    for (let i = 0; i < allAllowed.length; i++) {
        for (let j = 0; j < userRoles.length; j++) {
            if(allAllowed[i]==userRoles[j]){
                return true;
            }
        }
    }
    return false;
}

async function newMessage(username, message, text_channel_id){
    let foo = await conn.query(
        `insert into chats(username, message, text_channel_id, datetime) values ('${username}', '${message}', '${text_channel_id}', now())`
    )
}

async function getAllMessage(text_channel_id){
    let [result,metadata] = await conn.query(
        `select username, message, datetime from chats where text_channel_id = '${text_channel_id}'`
    )
    return result;
}

//no 1
app.post("/api/login", async (req,res)=>{
    let {username, password} = req.body;
    if(username&&password){
        let exists = await userExists(username);
        if(exists){
            let user = await getUserDetails(username);
            if(user.password==password){
                let token = jwt.sign({
                    username:username,
                }, JWT_KEY, {expiresIn: '3600s'});
                return res.status(200).send({
                    username:username,
                    token: token
                })
            }
            else{
                return res.status(400).send({
                    message:"Incorrect Password"
                })
            }
        }
        else{
            let [result,metadata] = await conn.query(
                `insert into users(username, password) values(:username, :password)`,{
                    replacements:{
                        username: username,
                        password: password
                    }
                }
            )
            let token = jwt.sign({
                username:username,
            }, JWT_KEY, {expiresIn: '3600s'});
            return res.status(201).send({
                username:username,
                token:token
            });
        }
    }
    else{
        return res.status(400).send({
            message:"Password/Username not given"
        })
    }
})

//no 2 
//x-auth-token user digunakan untuk membuat server.
app.post("/api/servers", async (req,res)=>{
    let token = req.header('x-auth-token');
    let name = req.body.name;
    if(token){
        let userdata = ""
        try {
            userdata = jwt.verify(token, JWT_KEY);
        } catch (error) {
            return res.status(403).send('Unauthorized Token.');
        }
        
        let username = userdata.username;
        if(name){
            let ID_server = await generateServerID();
            let role = 'Admin';
            let role_id = 'SR000RL000';
            let generating = true;
            let join_code = "";
            while(generating){
                join_code = randomString(5, '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ');
                generating = await codeExists(join_code);
            }

            let [result,metadata] = await conn.query(
                `insert into servers(ID_server, server_name, join_code) values(:ID_server, :server_name, :join_code)`,{
                    replacements:{
                        ID_server:ID_server,
                        server_name:name,
                        join_code:join_code
                    }
                }
            )
            
            let foo = await conn.query(
                `insert into user_roles(username, ID_server, role_id, role_name) values(:username, :ID_server, :role_id, :role_name)`,{
                    replacements:{
                        username:username,
                        ID_server:ID_server,
                        role_name:role,
                        role_id:role_id
                    }
                }
            )
            
            let token = jwt.sign({
                username:username,
                ID_server:ID_server,
                role:role,
                role_id:role_id
            }, JWT_KEY, {expiresIn: '7200s'});

            return res.status(201).send({
                server_id:ID_server,
                name:name,
                join_code:join_code
            })
        }
        else{
            return res.status(400).send({
                message:"Server name not given."
            })
        }
    }
    else{
        return res.status(403).send({
            message:"User token not given. x-auth-token is null."
        })
    }
})

//no 3
app.post("/api/join/:server_code", async(req,res)=>{
    let token = req.header('x-auth-token');
    let server_code = req.params.server_code;
    if(token){
        let userdata;
        try {
            userdata = jwt.verify(token, JWT_KEY);
        } catch (error) {
            return res.status(403).send('Unauthorized Token.');
        }
        let codeExisted = await codeExists(server_code);
        if(codeExisted){
            let serverDetails = await getServerFromJoinCode(server_code);
            let username = userdata.username;
            let userisBanned = await isUserBanned(username, serverDetails.ID_server);
            if(!userisBanned){
                let ID_server = serverDetails.ID_server;
                let role = "Member";
                let role_id = "SR000RL001";
                let foo = await conn.query(
                    `insert into user_roles(username, ID_server, role_id, role_name) values(:username, :ID_server, :role_id, :role_name)`,{
                        replacements:{
                            username:username,
                            ID_server:ID_server,
                            role_name:role,
                            role_id:role_id
                        }
                    }
                )
                return res.status(200).send({
                    message:`You've successfully joined the server ${serverDetails.server_name}`
                })
            }
            else{
                return res.status(403).send({
                    message:"You are currently being banned from joining the group"
                });
            }
        }
        else{
            return res.status(404).send({
                message:"The server join code doesn't exist"
            })
        }
    }
    else{
        return res.status(403).send({
            message:"User token not given. x-auth-token is null."
        })
    }
})

//no 4
app.post("/api/roles", async(req,res)=>{
    let {server_id, role_name} = req.body;
    let token = req.header('x-auth-token');
    if(token){
        if(server_id&&role_name){
            let userdata;
            try {
                userdata = jwt.verify(token, JWT_KEY);
            } catch (error) {
                return res.status(403).send('Unauthorized Token.');
            }
            let username = userdata.username;
            let userJoined = await userAlreadyJoined(username,server_id);
            console.log(userJoined);
            if(userJoined){
                let user_details = await getUserRole(username,server_id);
                console.log(user_details);
                if(user_details.role_name=="Admin"){
                    let role_id = await generateRoleID(server_id);
                    let foo = await conn.query(
                        `insert into roles(role_name, role_id, ID_server) values(:role_name, :role_id, :ID_server)`,{
                            replacements:{
                                role_name:role_name,
                                role_id:role_id,
                                ID_server:server_id
                            }
                        }
                    )
                    return res.status(201).send({
                        role_id:role_id,
                        message:`The role ${role_name} has been created`
                    })
                }
                else{
                    return res.status(403).send({
                        message:"Unauthorized Access"
                    })
                }
            }
            else{
                return res.status(403).send({
                    message:"Unauthorized Access"
                })
            }
        }
        else{
            return res.status(400).send({
                message:"Missing arguments on request body. (required: server_id and role_name)"
            })
        }
    }
    else{
        return res.status(403).send({
            message:"User token not given. x-auth-token is null."
        })
    }
})

//no 5.
app.post("/api/text-channels", async(req,res)=>{
    let token = req.header('x-auth-token');
    let {server_id, channel_name, allowed_roles} = req.body;
    if(token){
        if(server_id&&channel_name){
            let userdata;
            try {
                userdata = jwt.verify(token, JWT_KEY);
            } catch (error) {
                return res.status(403).send('Unauthorized Token.');
            }
            let username = userdata.username;
            let userJoined = await userAlreadyJoined(username,server_id);
            if(userJoined){
                let user_details = await getUserRole(username,server_id);
                if(user_details.role_name=="Admin"){
                    let text_channel_id = await generateChannelID(server_id);
                    let foo = conn.query(
                        `insert into text_channels(text_channel_id, ID_server, channel_name) values('${text_channel_id}', '${server_id}', '${channel_name}')`
                    )
                    if(allowed_roles){
                        for (let index = 0; index < allowed_roles.length; index++) {
                            const element = allowed_roles[index];
                            let roleDetails = await getRoleDetails(element);
                            let RoleExist = await RoleExists(element);
                            if(RoleExist){
                                console.log(roleDetails);
                                let foo2 = await conn.query(
                                    `insert into allowed_roles(text_channel_id, role_id, role_name) values('${text_channel_id}', '${element}', '${roleDetails.role_name}')`
                                )
                            }
                        }
                    }
                    else{
                        let foo2 = await conn.query(
                            `insert into allowed_roles(text_channel_id, role_id, role_name) values('${text_channel_id}', 'SR000RL001', 'Member')`
                        )
                    }
                    let [result,metadata] = await conn.query(
                        `select * from allowed_roles where text_channel_id = '${text_channel_id}'`
                    )
                    let temp = {
                        text_channel_id:text_channel_id,
                        message:`Text channel ${channel_name} has been created`,
                        role_access:result
                    }
                    return res.status(201).send(temp);
                }
                else{
                    return res.status(403).send({
                        message:"Unauthorized Access"
                    })
                }
            }
            else{
                return res.status(404).send({
                    message:"User isn't a part of server member"
                })
            }
        }
        else{
            return res.status(400).send({
                message:"Missing arguments. Required(server_id, channel_name, allowed_roles(array))"
            })
        }
    }
    else{
        return res.status(403).send({
            message:"User token not given. x-auth-token is null."
        })
    }
})

//no 6
app.put("/api/text-channels/:text_channel_id", async(req,res)=>{

})

//no 7
app.put("/api/servers/:server_id/assign", async(req,res)=>{
    let token = req.header('x-auth-token');
    let {username, role_id} = req.body;
    let server_id = req.params.server_id;
    if(token){
        if(username&&role_id&&server_id){
            let userdata;
            try {
                userdata = jwt.verify(token, JWT_KEY);
            } catch (error) {
                return res.status(403).send('Unauthorized Token.');
            }
            let username_data = userdata.username;
            let user_details = await getUserRole(username_data,server_id);
            let userJoined = await userAlreadyJoined(username,server_id);
            console.log(userJoined);
            if(userJoined){
                console.log("tolong pls")
                console.log(user_details);
                if(user_details.role_name=="Admin"){
                    let serverRole = await isServerRole(server_id, role_id);
                    if(serverRole){
                        let userAlrHasRole = await userHasRole(username,role_id);
                        if(userAlrHasRole){
                            let RoleDetails = await getRoleDetails(role_id);
                            await removeUserRole(username,role_id,server_id);
                            return res.status(200).send(
                                {
                                    message: `The role ${RoleDetails.role_name} has been removed from the user`
                                }
                            )
                        }
                        else{
                            let RoleDetails = await getRoleDetails(role_id);
                            await giveUserRole(username, server_id,role_id,RoleDetails.role_name);
                            return res.status(200).send(
                                {
                                    message: `The role ${RoleDetails.role_name} has been added from the user`
                                }
                            )
                        }
                        
                    }
                    else{
                        return res.status(404).send({
                            message:"The server doesn't have the given role"
                        })
                    }
                }
                else{
                    return res.status(403).send({message:'Unauthorized Access.'});
                }
            }
            else{
                return res.status(404).send({
                    message:"User isn't a part of server member"
                })
            }
        }
        else{
            return res.status(400).send({
                message:"Missing arguments. Required(server_id, channel_name, allowed_roles(array))"
            })
        }
    }
    else{
        return res.status(403).send({
            message:"User token not given. x-auth-token is null."
        })
    }
})

//no 8
app.put("/api/servers/:server_id/members", async (req,res)=>{
    let token = req.header('x-auth-token');
    let {action, usernames} = req.body;
    let server_id = req.params.server_id;
    if(token){
        if(action&&usernames&&server_id){
            let userdata;
            try {
                userdata = jwt.verify(token, JWT_KEY);
            } catch (error) {
                return res.status(403).send('Unauthorized Token.');
            }
            let userJoined = await userAlreadyJoined(username,server_id);
            let username_data = userdata.username;
            let user_details = await getUserRole(username_data,server_id);
            if(userJoined){
                if(user_details.role_name=="Admin"){
                    if(action==="kick"){
                        for (let index = 0; index < usernames.length; index++) {
                            const username = usernames[index];
                            await kickUser(username,server_id);
                        }
                        return res.status(200).send({
                            message: "Users have been successfully kicked"
                        })
                    }
                    else if(action==="ban"){
                        for (let index = 0; index < usernames.length; index++) {
                            const username = usernames[index];
                            await banUser(username,server_id);
                            await kickUser(username,server_id);
                        }
                        return res.status(200).send({
                            message: "Users have been successfully banned"
                        })
                    }
                    else{
                        return res.status(400).send({
                            message:"Invalid Action parameter. (allowed params: kick, ban)"
                        })
                    }
                }
                else{
                    return res.status(403).send({message:'Unauthorized Access.'});
                }
            }
            else{
                return res.status(404).send({
                    message:"User isn't a part of server member"
                })
            }
        }
        else{
            return res.status(400).send({
                message:"Missing arguments. Required(server_id, channel_name, allowed_roles(array))"
            })
        }
        
    }
    else{
        return res.status(403).send({
            message:"User token not given. x-auth-token is null."
        })
    }
})

//no 9
app.post("/api/text-channels/:text_channel_id", async (req,res)=>{
    let token = req.header('x-auth-token');
    let text = req.body.text;
    let text_channel_id = req.params.text_channel_id;
    if(token){
        if(text_channel_id, text){
            let userdata;
            try {
                userdata = jwt.verify(token, JWT_KEY);
            } catch (error) {
                return res.status(403).send('Unauthorized Token.');
            }
            let username_data = userdata.username;
            let userCanSend = await userCanSendMessage(username_data, text_channel_id);
                if(userCanSend){
                    await newMessage(username_data, text, text_channel_id);
                    let allMsg = await getAllMessage(text_channel_id);
                    return res.status(200).send({chats:allMsg});
                }
                else{
                    return res.status(403).send({
                        message:"Lu itu gak diajak :("
                    })
                }
        }
        else{
            return res.status(400).send({
                message:"Missing arguments. Required(server_id, channel_name, allowed_roles(array))"
            })
        }
    }
    else{
        return res.status(403).send({
            message:"User token not given. x-auth-token is null."
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