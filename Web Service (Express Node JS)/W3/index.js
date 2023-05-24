const express = require("express");
const { format } = require("mysql2");
const app = express();
const sequelize = require("sequelize");
const { Model, DataTypes } = require("sequelize");
const { Op } = require("sequelize");
const port = 3000;
app.use(express.urlencoded({ extended: true }));

const conn = new sequelize("t3_ws_221116955", "root", "", {
    host: "localhost",
    port: 3306,
    dialect: "mysql"
})

//Models

class Event extends Model{ }
class User extends Model{ }
class Attendee extends Model{ }
  
User.init(
    {
        id_user: {
            type: DataTypes.STRING,
            primaryKey: true,
            allowNull: false,
        },
        nama: {
            type: DataTypes.STRING,
            allowNull: false,
        },
        password: {
            type: DataTypes.STRING,
            allowNull: false,
        },
        nomor_HP: {
            type: DataTypes.STRING,
            allowNull: false,
        },
        jenis_kelamin: {
            type: DataTypes.STRING,
            allowNull: false,
        },
        email: {
            type: DataTypes.STRING,
            allowNull: false,
            unique:true,
        },
    },
    {
      sequelize: conn,
      timestamps: false,
      modelName: "User",
      tableName: "users",
    }
);

Event.init(
    {
        id_event:{
            type: DataTypes.STRING,
            primaryKey: true,
            allowNull: false,
        },
        nama:{
            type: DataTypes.STRING,
            allowNull: false,
        },
        deskripsi:{
            type: DataTypes.STRING,
            allowNull: false,
        },
        lokasi:{
            type: DataTypes.STRING,
            allowNull: false,
        },
        tanggal:{
            type: DataTypes.STRING,
            allowNull: false,
        },
        id_user: {
            type: DataTypes.STRING,
            references:{
                model:'users',
                key:'id_user'
            },
            allowNull: false,
        }
    },
    {
        sequelize: conn,
        timestamps: true,
        modelName: "Event",
        tableName: "events",
    }
)

Attendee.init(
    {
        id_event:{
            type: DataTypes.STRING,
            references:{
                model:'events',
                key:'id_event'
            },
            allowNull:false
        },
        id_user: {
            type: DataTypes.STRING,
            references:{
                model:'users',
                key:'id_user'
            },
            allowNull: false,
        }
    },
    {
        sequelize: conn,
        timestamps: false,
        modelName: "Attendee",
        tableName: "attendees",
    }
)
//remove default attribute for a table with no PK.
Attendee.removeAttribute('id');

function formatDate(inputDate) {
    let date, month, year;
    date = inputDate.getDate();
    month = inputDate.getMonth() + 1;
    year = inputDate.getFullYear();
    date = date.toString().padStart(2, '0');
    month = month.toString().padStart(2, '0');
    return `${date}/${month}/${year}`;
}

//create userID
function generateID(x,mode){
    let result = null;
    (mode===1)? result = "EX" : result = "EV"
    let pr = parseInt((x/10000)%10).toString();
    let rb = parseInt((x/1000)%10).toString();
    let rt = parseInt((x/100)%10).toString();
    let p = parseInt((x/10)%10).toString();
    let s = parseInt(x%10).toString();
    result = result+pr+rb+rt+p+s;
    console.log(result);
    return result;
}

//check for dupe emails
async function isDupe(email){
    try{
        let q = await User.findAndCountAll({
            where:{
                email: email
            }
        });
        //console.log(q.count);
        if(q.count>0) return true;
        return false;
    }catch(error){
        return error;
    }
}

//check if user exists.
async function exists(id){
    try{
        let q = await User.findAndCountAll({
            where:{
                id_user:id
            }
        });
        console.log(q.count);
        if(q.count>0) return true;
        return false;
    }catch(error){
        return error;
    }
}

//check if event exists
async function eventExists(id){
    try{
        let q = await Event.findAndCountAll({
            where:{
                id_event:id
            }
        });
        console.log(q.count);
        if(q.count>0) return true;
        return false;
    }catch(error){
        return error;
    }
}

//get user info by id
async function getUserByID(id){
    try {
        let q = await User.findOne({
            where:{
                id_user:id
            }
        })
        return q.dataValues;
    } catch (error) {
        console.log(error);
        return null;
    }
}

async function getEventByID(id){
    try {
        let q = await Event.findOne({
            where:{
                id_event:id
            }
        })
        return q.dataValues;
    } catch (error) {
        console.log(error);
        return null;
    }
}

//get All user tickets
async function getAllUserTickets(id){
    try {
        let q = await Attendee.findAll({
            where:{
                id_user:id
            }
        })
        let ticketList = [];
        let result = [];
        let temp = null;
        for (let index = 0; index < q.length; index++) {
            temp = q[index].dataValues;
            ticketList.push(temp);
        }
        for(ticket of ticketList){
            let tarEvent = await Event.findByPk(ticket.id_event);
            result.push({id_event:ticket.id_event ,nama: tarEvent.nama});
        }
        return result;
    } catch (error) {
        console.log(error);
    }
}

//get all attendees of an event function
async function getAllAttendees(id){
    try{
        let q = await Attendee.findAll({
            where:{
                id_event:id
            }
        })
        let result = [];
        for(let obj of q){
            result.push(obj);
        }
        return result;
    }catch(error){
        return error;
    }
}

//get all events from db
async function getAllEvents(){
    try{
        let q = await Event.findAll()
        let result = [];
        for(let obj of q){
            result.push(obj);
        }
        return result;
    }catch(error){
        return error;
    }
}

//Attendee processing
async function attendeeProcessing(arr){
    let result = [];
    for(let a of arr){
        let temp = await getUserByID(a.id_user);
        let newLoad = {
            id_user: a.id_user,
            nama: temp.nama
        }
        result.push(newLoad);
    }
    return result;
}

//get all events on query
async function getAllEventsQuery(nama,lokasi){
    console.log("hello");
    try{
        let q = await Event.findAll({
            where:{
                nama:{
                    [Op.like]: '%'+nama+'%'
                },
                lokasi:{
                    [Op.like]: '%'+lokasi+'%'
                }
            }
        })
        let tempArr = [];
        for(let obj of q){
            tempArr.push(obj.dataValues);
        }
        let result = [];
        for(let obj of tempArr){
            let process = {
                id_event: obj.id_event,
                id_user: obj.id_user,
                nama: obj.nama,
                deskripsi: obj.deskripsi,
                lokasi: obj.lokasi,
                tanggal: obj.tanggal,
                peserta: await attendeeProcessing(await getAllAttendees(obj.id_event)),
                createdAt: formatDate(new Date(obj.createdAt))
            }
            result.push(process);
        }
        return result;
    }catch(error){
        console.log(error);
        return null;
    }
}

//create new user
async function createNew(email,nama,jenis_kelamin,nomor_HP,password){
    let user = null;
    try{
        let count = await User.count();
        user = await User.create({
            id_user: generateID(++count,1),
            nama:nama,
            password:password,
            nomor_HP:nomor_HP,
            jenis_kelamin:jenis_kelamin,
            email:email
        })
        return user;
    }catch(error){
        console.log(error);
        return error;
    }
}

//Create new event
async function createNewEvent(id_user,nama,deskripsi,lokasi,tanggal){
    let event = null;
    try{
        let count = await Event.count();
        event = await Event.create({
            id_event: generateID(++count, 0),
            nama: nama,
            deskripsi: deskripsi,
            lokasi:lokasi,
            tanggal:tanggal,
            id_user:id_user
        })
        return event;
    }catch(error){
        console.log(error);
        return error;
    }
}

//check date
function isLaterValidDate(date){
    const curDate = new Date(Date.now());
    date = new Date(date);
    if(curDate<date) return true;
    return false;
}

function stringToDate(date){
    let temp = date.split("/");
    return new Date(temp[2]+"-"+temp[1]+"-"+temp[0]);
}

//string s for input. checks date string format.
function dateChecker(s){
    if(isValidDateFormat(s)){
        let date = stringToDate(s);
        if(isLaterValidDate(date))return true;
        return false;
    }
    else{
        return false;
    }
}

function isValidDateFormat(x){
    console.log("Check if format is valid")
    const date = x.split("/");
    if(date.length===3){
        if(date[0].length===2&&date[1].length===2&&date[2].length===4) return true;
        return false;
    }
    return false;
}

//No. 1
app.post("/api/user", async (req, res)=>{
    let {email, nama, jenis_kelamin, nomor_HP, password} = req.body;
    if(email,nama,jenis_kelamin,nomor_HP,password){
        let dupe = await isDupe(email);
        if(!dupe){
            let user = await createNew(email,nama,jenis_kelamin,nomor_HP,password);
            let body = {
                id: user.id_user,
                email: user.email,
                nama: user.nama,
                jenis_kelamin: user.jenis_kelamin,
                nomor_HP: user.nomor_HP
            }
            return res.status(201).send(body);
        }
        else{
            return res.status(400).send({msg: "Email tersebut sudah digunakan."});
        }
    }
    else{
        return res.status(400).send("Terdapat field yang kosong/format salah/tidak ada.");
    }
})

//No. 2
//no pengecekan tanggal lebih besar.
app.post("/api/event", async(req,res)=>{
    let {id_user, nama,deskripsi, lokasi,tanggal} = req.body;
    if(id_user,nama,deskripsi,lokasi,tanggal){
        let exist = await exists(id_user);
        if(exist){
            if(dateChecker(tanggal)){
                let newEvent = await createNewEvent(id_user,nama,deskripsi,lokasi,tanggal);
                let attendeesList = await getAllAttendees(newEvent.id_event);
                if(newEvent&&attendeesList){
                    let result = {
                        id_event: newEvent.id_event,
                        id_user: newEvent.id_user,
                        nama: newEvent.nama,
                        deskripsi: newEvent.deskripsi,
                        lokasi: newEvent.lokasi,
                        tanggal: newEvent.tanggal,
                        peserta: attendeesList,
                        createdAt: formatDate(newEvent.createdAt)
                    }
                    return res.status(201).send(result);
                }
            }
            else{
                return res.status(400).send({msg:"Terdapat field yang kosong/format salah/tidak ada."})
            }
        }
        else{
            return res.status(400).send({msg:"id user organizer tidak terdaftar."})
        }
    }
    else{
        return res.status(400).send({msg:"Terdapat field yang kosong/format salah/tidak ada."})
    }
})

//No 3
app.put("/api/event/:id", async (req,res)=>{
    let {nama, deskripsi, lokasi, tanggal} = req.body;
    let id = req.params.id;
    let existed = await eventExists(id);
    if(existed){
        if(nama){
            try{
                let update = await Event.update(
                    {
                        nama:nama
                    },
                    {
                        where:{
                            id_event:id
                        }
                    }
                )
            }
            catch(error){
                return res.status(400).send({error: "Error updating Event name."})
            }
        }
        if(deskripsi){
            try{
                let update = await Event.update(
                    {
                        deskripsi:deskripsi
                    },
                    {
                        where:{
                            id_event:id
                        }
                    }
                )
            }
            catch(error){
                return res.status(400).send({error: "Error updating Event description."})
            }
        }
        if(lokasi){
            try{
                let update = await Event.update(
                    {
                        lokasi:lokasi
                    },
                    {
                        where:{
                            id_event:id
                        }
                    }
                )
            }
            catch(error){
                return res.status(400).send({error: "Error updating Event name."})
            }
        }
        if(tanggal){
            if(dateChecker(tanggal)){
                try{
                    let update = await Event.update(
                        {
                            tanggal:tanggal
                        },
                        {
                            where:{
                                id_event:id
                            }
                        }
                    )
                }
                catch(error){
                    return res.status(400).send({error: "Error updating Event date."})
                }
            }
            else{
                return res.status(400).send({msg:"Terdapat field yang kosong/format salah/tidak ada."})
            }
        }
        let event = await getEventByID(id);
        const newLoad = {
            id_event: id,
            id_user: event.id_user,
            nama: event.nama,
            deskripsi: event.deskripsi,
            lokasi: event.lokasi,
            tanggal: event.tanggal,
            peserta: await attendeeProcessing(await getAllAttendees(id)),
            createdAt: event.createdAt
        }
        return res.status(201).send(newLoad);
    }
    else{
        return res.status(400).send({message:"ID event tersebut tidak terdaftar."})
    }
})

//No 4
app.get("/api/event/all", async(req, res)=>{
    let q = await getAllEvents();
    let result = [];
    for(let obj of q){
        let temp = obj.dataValues;
        let peserta = await getAllAttendees(temp.id_event);
        let tempArr = {
            id_event:temp.id_event,
            id_user:temp.id_user,
            nama:temp.nama,
            deskripsi:temp.deskripsi,
            lokasi:temp.lokasi,
            tanggal:temp.tanggal,
            peserta:peserta,
            createdAt:formatDate(new Date(temp.createdAt))
        }
        result.push(tempArr);
    }
    if(result.length===0){
        return res.status(404).send({message:"Tidak ada event!"})
    }
    return res.status(200).send(result);
})

//no 5
app.get("/api/event", async(req,res)=>{
    let {nama, lokasi} = req.query;
    if(nama&&lokasi){
        let data = await getAllEventsQuery(nama,lokasi);
        if(data.length===0){
            return res.status(404).send({message:"Tidak ada event"})
        }
        return res.status(200).send(data);
    }
    else{
        return res.status(400).send({msg: "missing params"})
    }
})

//no 6
app.post("/api/event/register",async (req, res)=>{
    let {id_user, id_event} = req.body;
    if(id_user&&id_event){
        if(await exists(id_user)&&await eventExists(id_event)){
            try{
                let ticket = await Attendee.create({
                    id_user:id_user,
                    id_event:id_event
                })
                return res.status(201).send({message:"User berhasil melakukan registrasi event"})
            }
            catch(error){
                console.log(error);
                return res.status(400).send(error);
            }
        }
        else{
            return res.status(404).send({message:"User/Event tidak terdaftar."})
        }
    }
    else{
        return res.status(400).send({msg:"Missing fields/arguments id_user/id_event tidak ditemukan."})
    }
})

//no 7
app.get("/api/user/:id", async (req,res)=>{
    let id = req.params.id;
    if(id){
        let user = await getUserByID(id);
        //console.log(user);
        if(user){
            let tickets = await getAllUserTickets(user.id_user);
            let load = {
                id: id,
                nama: user.nama,
                tiket: tickets
            }
            return res.status(200).send(load);
        }
        else{
            return res.status(404).send({message:"User tidak ditemukan"})
        }
    }
    else{
        return res.status(400).send({message:"user id tidak di inputkan."})
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

//test endpoint.
app.post("/api/testing", async (req,res)=>{
    //generateUID(1);
    //isDupe("x@gmail.com");
    //let a = await exists("EX00001");
    //return res.status(200).send('test initiated.');
    //getUserByID("EX00100");
    //getAllUserTickets("EX00001");
    //getAllEventsQuery("Seminar","rumah");
})

initApp();