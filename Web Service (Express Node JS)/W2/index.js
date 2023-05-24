const express = require("express");
const app = express();
const sequelize = require("sequelize");
const port = 3000;
app.use(express.urlencoded({ extended: true }));

const conn = new sequelize("t2_6955", "root", "", {
    host: "localhost",
    port: 3306,
    dialect: "mysql"
})

async function isDup(username){
    let [dup, metadata] = await conn.query(
        `select Count(username) as count from users where username = :username`,
        {
            replacements:{
                username: username
            }
        }
    )
    return dup[0].count;
}

async function getUserCount(id){
    id = id+"%";
    let count = await conn.query(
        `Select COUNT(*) as count from users where username like :id`,{
            replacements:{
                id: id
            }
        }
    )
    console.log(count[0][0].count);
    return count[0][0].count;
}

async function getDeviceCount(){
    let count = await conn.query(
        `Select COUNT(*) as count from devices`
    )
    return count[0][0].count;
}

async function getScheduleCount(){
    let count = await conn.query(
        `Select COUNT(*) as count from schedules`
    )
    return count[0][0].count;
}

async function generateID(username){
    let id = username[0]+username[1];
    let count = await getUserCount(id);
    count++;
    let satuan = parseInt(count%10);
    let puluhan = parseInt((count/10)%10);
    let ratusan = parseInt(count/100);

    let generateID = username[0].toUpperCase()+username[1].toUpperCase()+ratusan+puluhan+satuan;
    return generateID;
}

async function generateDeviceID(name){
    let count = await getDeviceCount();
    count++;
    let satuan = parseInt(count%10);
    let puluhan = parseInt((count/10)%10);
    let ratusan = parseInt(count/100);
    let generateID = "DEV"+name[0].toUpperCase()+name[1].toUpperCase()+ratusan+puluhan+satuan;
    return generateID;
}

async function generateScheduleID(){
    count = await getScheduleCount();
    let satuan = parseInt(count%10);
    let puluhan = parseInt((count/10)%10);
    let ratusan = parseInt(count/100);
    let generateID = "SCH"+ratusan+puluhan+satuan;
    return generateID;
}

async function getUserByName(name){
    name = "%"+name+"%";
    let [result,metadata] = await conn.query(
        `select * from users where name like :name`,
        {
            replacements:{
                name:name
            }
        }
    )
    let count = await conn.query(
        `select count(*) as count from users where name like :name`,
        {
            replacements:{
                name:name
            }
        }
    )
    let val = {
        total: count[0][0].count,
        users:result
    }
    return val;
}

async function getDeviceById(id){
    let [result, metadata] = await conn.query(
        `select * from devices where device_id = :id`,{
            replacements:{
                id:id
            }
        }
    )
    //console.log(result[0]);
    return result[0];
}
//get user data from ID
async function getUserByID(user_id){
    let [result,metadata] = await conn.query(
        `select * from users where user_id = :user_id`,{
            replacements:{
                user_id:user_id
            }
        }
    )
    return result[0];
}

//get devices array from keyword and userID
async function getDevicesByKeywordAndUserID(keyword,user_id){
    keyword = "%"+keyword+"%";
    let user = await getUserByID(user_id);
    let username = user.username;
    let [result, metadata] = await conn.query(
        `select device_id, name, description, state from devices where name like :keyword and username = :username`,
        {
            replacements:{
                keyword: keyword,
                username: username
            }
        }
    )
    result = await getAllDeviceSchedule(result);
    console.log(result);
    return result;
}

//get user_id from username
async function getUserIDByUsername(username){
    let [result,metadata] = await conn.query(
        `select user_id from users where username = :username`,
        {
            replacements:{
                username:username
            }
        }
    )
    return result[0].user_id;
}

//Get schedules array
async function getAllDeviceScheduleByID(id){
    let [result, metadata] = await conn.query(
        `select time_remaining, new_state from schedules where device_id = :id`,
        {
            replacements:{
                id:id
            }
        }
    )
    //console.log(result)
    return result;
}

//iterate getAllDeviceScheduleByID
async function getAllDeviceSchedule(devices){
    for (let element of devices) {
        let temp = await getAllDeviceScheduleByID(element.device_id);
        element.active_schedules = JSON.stringify(temp);
    }
    //console.log(devices);
    return devices;
}

function checkValid(s){
    if(s.includes("h")&&s.includes("m")){
        return false;
    }
    else if(s.includes("h")||s.includes("m")){
        let temp = s.split(" ");
        if(temp.length>1){
            return false;
        }
        else return true;
    }
    else{
        return false;
    }
}

function isHour(s){
    return s.includes("h");
}

function HourToMinute(hour){
    return hour*60;
}

function timeDBFormat(a){
    let hour = parseInt(a/60);
    let minutes = parseInt(a%60);
    if(hour>=1) return hour+"h "+minutes+"m";
    else return minutes+"m";
}

async function updateTimer(time){
    let [result, metadata] = await conn.query(
        `select * from schedules where active = 'active'`
    )
    schedule = result;
    if(schedule){
        for(let element of schedule){
            let schedule_timer = (element.hour*60)+element.minute;
            if(schedule_timer<=time){
            let[x,meta] = await conn.query(
                `update schedules set time_remaining = '0m', active = 'false', hour = 0, minute = 0 where id = :id`,
                {
                    replacements:{
                        id:element.id
                    }
                }
            )
            }
            else{
                let newTime = (element.hour*60)+element.minute;
                newTime = newTime - time;
                let newTimeFormat = timeDBFormat(newTime);
                let hour = parseInt(newTime/60);
                let minute = parseInt(newTime%60);
                let[x,meta] = await conn.query(
                    `update schedules set time_remaining = :newTimeFormat, hour = :hour, minute = :minute where id = :id`,
                    {
                        replacements:{
                            newTimeFormat:newTimeFormat,
                            hour: hour,
                            minute: minute,
                            id: element.id
                        }
                    }
                )
            }
        }
    }
}

//updateTimer(30, "DEVFR003");

//No 1
app.post("/api/users", async (req,res)=>{
    let {username, email_address, name} = req.body;
    if(username&&email_address&&name){
        if(username.length>0&&email_address.length>0&&name.length>0){
            let exist = await isDup(username);
            console.log(exist);
            if(exist>0){
                return res.status(400).send({message:"Username has been taken"})
            }
            else{
                user_id=await generateID(username);
                let [result, metadata] = await conn.query(
                    `insert into users (user_id, username, name, email_address, active) values(:user_id, :username, :name, :email_address, :active)`,
                    {
                        replacements: {
                            user_id: user_id,
                            username: username, 
                            name: name,
                            email_address: email_address,
                            active: true
                        }
                    }
                )
                return res.status(201).send({
                    user_id:user_id,
                    name:name,
                    username:username,
                    email_address:email_address
                });
            }
        }
        else{
            return res.status(400).send({message:"Invalid Field Value"})
        }
    }
    else{
        return res.status(400).send({message:"Invalid Field Value"})
    }
})

//No 2
app.post("/api/devices",async (req,res)=>{
    let{username, name, description} = req.body;
    if(username&&description){
        if(name&&name.length>0){
            let exist = await isDup(username);
            if(exist>0){
                let deviceID = await generateDeviceID(username);
                let [result, metadata] = await conn.query(
                    `insert into devices (device_id, username,  name, description, state) values(:device_id, :username, :name, :description, :state)`,
                    {
                        replacements: {
                            device_id: deviceID,
                            username: username, 
                            name: name,
                            description: description,
                            state: "OFF"
                        }
                    }
                )
                return res.status(201).send({
                    device_id: deviceID,
                    username: username, 
                    name: name,
                    description: description,
                    state: "OFF"
                });
            }
            else{
                return res.status(404).send({message:"User not found"})
            }
        }
    }
    else{
        return res.status(400).send({message:"Invalid Field Value"})
    }
})

//No 3
app.get("/api/users", async(req,res)=>{
    let params = req.query.keyword;
    if(params){
        return res.status(200).send(await getUserByName(params));
    }
    else{
        return res.status(404).send("Query params not found");
    }
})

//No 4
app.get("/api/devices",async(req,res)=>{
    let {user_id, keyword} = req.query;
    if(user_id&&keyword){
        let devices = await getDevicesByKeywordAndUserID(keyword,user_id);
        let user = await getUserByID(user_id);
        let message = {
            username: user.username,
            name: user.name,
            devices: devices
        }
        return res.status(200).send(message);
    }
    else{
        return res.status(400).send({message: "Missing query"})
    }
})

//No 5
app.put("/api/devices/:device_id", async(req,res)=>{
    let param = req.params.device_id;
    let {user_id, state} = req.body;
    if(param&&user_id&&state){
        state = state.toUpperCase();
        if(state=="OFF"||state=="ON"){
            let temp = await getDeviceById(param);
            let userID = await getUserIDByUsername(temp.username);
            let change;
            let message;
            if(userID==user_id){
                if(temp.state==state){
                    message = {
                        message: "State does not change",
                        name: temp.name,
                        prev_state: temp.state,
                        cur_state: temp.state
                    }
                    return res.status(200).send(message);
                }
                else{
                    let [result,metadata] = await conn.query(
                        `update devices set state = :state where device_id = :device_id`,{
                            replacements:{
                                state: state,
                                device_id: param
                            }
                        }
                    )
                    message = {
                        message: "Switched Successfully",
                        name: temp.name,
                        prev_state: temp.state,
                        cur_state: state
                    }
                    return res.status(200).send(message)
                }
            }
            else{
                return res.status(400).send({message:"Unauthorized state update"})
            }
        }
        else{
            return res.status(400).send({message:"State should be either OFF/ON"})
        }
    }
    else{
        return res.status(400).send({message: "Missing params/arguments"})
    }
})

//No 6
app.post("/api/schedules",async (req,res)=>{
    let {user_id, device_id, timer, new_state} = req.body;
    if(user_id&&device_id&&timer&&new_state){
        let user = await getUserByID(user_id);
        let device = await getDeviceById(device_id);
        let correct_format = checkValid(timer);
        if(correct_format){
            if(device.username==user.username){
                let endTime;
                if(isHour(timer)){
                    endTime = HourToMinute(timer.replace(/[^0-9]/g, ''));
                }
                else{
                    endTime = timer.replace(/[^0-9]/g, '');
                }
                let hour = parseInt(endTime/60);
                let minute = parseInt(endTime%60);
                let newID = await generateScheduleID();
                let [result, metadata] = await conn.query(
                    `insert into schedules (device_id, time_remaining, new_state, active, hour, minute, id) values (:device_id, :time_remaining, :new_state, :active, :hour, :minute, :id)`,{
                        replacements:{
                            device_id:device.device_id,
                            time_remaining: timeDBFormat(endTime),
                            new_state: new_state,
                            active: "active",
                            hour:hour,
                            minute:minute,
                            id: newID
                        }
                    }
                )
                return res.status(201).send({
                    message:"Schedule created successfully",
                    name: device.name,
                    timer: timeDBFormat(endTime),
                    new_state: new_state
                })
            }
            else{
                return res.status(400).send({message:"Unauthorized scheduling"})
            }
        }
        else{
            return res.status(400).send({message:"Invalid timer field"})
        }
        
    }

})

//No 7
app.put("/api/timer", async (req,res)=>{
    let timer = req.body.timer;
    if(timer){
        let time;
        let valid = checkValid(timer);
        if(valid){
            if(isHour(timer)){
                time = HourToMinute(parseInt(timer.replace(/[^0-9]/g, '')));
            }
            else{
                time = parseInt(timer.replace(/[^0-9]/g, ''));
            }
            let triggered = [];
            let [result, metadata] = await conn.query(
                `select * from schedules where active = 'active'`
            )
            for(let schedule of result){
                let tempTime = (schedule.hour*60)+schedule.minute;
                if(tempTime<=time){
                    triggered.push(schedule);
                }
            }
            let list = [];
            for(let element of triggered){
                let device = await getDeviceById(element.device_id);
                let t = {
                    device_id:element.device_id,
                    name: device.name,
                    new_state: element.new_state
                }
                list.push(t);
            }
            await updateTimer(time);
            return res.status(200).send({
                message:"Timer Successfully changed",
                triggered_schedules: list
            })
        }
        else{
            return res.status(400).send({message:"Invalid timer field"})
        }
    }
    else{
        return res.status(400).send({message:"Missing time argument"})
    }
})

const initApp = async () => { 
    console.log("Testing database connection");
    try {
        await conn.authenticate();
        console.log("Successfully connected!");
        app.listen(port, () =>
            console.log(`App listening on port ${port}!`)
        );
    } catch (error) {
        console.error("Failed database connection : ", error.original);
    }
}

initApp();

//isDup("Frans");
//getUserCount("X");
//generateID("Frans");
//getDeviceCount();
//getUserByName("ran");
//getUserIDByUsername("Frans1");
//getDeviceById("DEVFR002");      
//getDeviceByKeyword("i");
//getUserByID("FR001");
//getDevicesByKeywordAndUserID("i","FR001");
//getAllDeviceScheduleByID("DEVFR002");
//console.log(checkString("1h 2m"));