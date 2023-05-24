const express = require("express")
const Joi = require('joi').extend(require('@joi/date'));
const app = express();
const sequelize = require("sequelize")
const port = 3000;
const sql = require("mysql2");
const { valid } = require("joi");

app.use(express.urlencoded({extended: true}));

const conn = new sequelize("t4_6955", "root", "",{
    host: "localhost",
    port: 3306,
    dialect: "mysql"
});

//check if account email is unique
async function isUnique(email){
    let foo = await conn.query(
        `select COUNT(*) as count from account where email = :email`,{
            replacements:{
                email:email
            }
        }
    )
    let count =  foo[0][0].count;
    if(count==0) return true;
    throw new Error("Email tersebut sudah digunakan.");
}

//get amount of account in db
async function getAccountCount(){
    let count = await conn.query(
        `Select COUNT(*) as count from account`
    )

    return count[0][0].count;
}

//get amount of module in db
async function getModuleCount(){
    let count = await conn.query(
        `Select COUNT(*) as count from module`
    )
    console.log(count[0][0].count);
    return count[0][0].count;
}

//get amount of questions in db
async function getQuestionCount(){
    let count = await conn.query(
        `Select COUNT(*) as count from question`
    )
    console.log(count[0][0].count);
    return count[0][0].count;
}

//generate new account id (AC+3 digit)
async function generateID(){
    let id = "AC";
    let count = await getAccountCount();
    count++;
    let satuan = parseInt(count%10);
    let puluhan = parseInt((count/10)%10);
    let ratusan = parseInt(count/100);

    let generateID = id+ratusan+puluhan+satuan;
    return generateID;
}

//generate new Module id (MO+3 digit)
async function generateModuleID(){
    let id = "MO";
    let count = await getModuleCount();
    count++;
    let satuan = parseInt(count%10);
    let puluhan = parseInt((count/10)%10);
    let ratusan = parseInt(count/100);

    let generateID = id+ratusan+puluhan+satuan;
    return generateID;
}

//generate new Question ID (QU+3 digit)
async function generateQuestionID(){
    let id = "QU";
    let count = await getQuestionCount();
    count++;
    let satuan = parseInt(count%10);
    let puluhan = parseInt((count/10)%10);
    let ratusan = parseInt(count/100);

    let generateID = id+ratusan+puluhan+satuan;
    return generateID;
}

//insert new user to db
async function insertNewAccount(newAcc){
    if(newAcc){
        let [result, metadata] = await conn.query(
            `insert into account (id, email, nama_lengkap, nomor_telepon, password) values (:id, :email, :nama_lengkap, :nomor_telepon, :password)`,
            {
                replacements:{
                    id: newAcc.id,
                    email: newAcc.email,
                    nama_lengkap: newAcc.nama_lengkap,
                    nomor_telepon: newAcc.nomor_telepon,
                    password: newAcc.password
                }
            }
        )
        return (result != null);
    }
    else{
        console.log("bruh")
        return false;
    }
}

//check if account exists
async function AccountExists(id){
    let [exist, metadata] = await conn.query(
        `select * from account where id = :id`,
        {
            replacements:{
                id: id
            }
        }
    )
    console.log(exist);
    if(exist.length>0){
        return true;
    }
    else{
        throw new Error("Account tidak terdaftar.");
    }
}

//check if module exists
async function ModuleExists(id){
    let [exist, metadata] = await conn.query(
        `select * from module where id = :id`,
        {
            replacements:{
                id: id
            }
        }
    )
    console.log(exist);
    if(exist.length>0){
        return true;
    }
    else{
        throw new Error("Module tidak ditemukan!");
    }
}

//insert new module to db
async function insertNewModule(newModule){
    if(newModule){
        let [result, metadata] = await conn.query(
            `insert into module(id, pembuat_modul, nama_modul, password) values(:id, :pembuat_modul, :nama_modul, :password)`,
            {
                replacements:{
                    id: newModule.id,
                    pembuat_modul: newModule.acc_id,
                    nama_modul: newModule.nama_modul,
                    password: newModule.password
                }
            }
        )
        return (result != null);
    }
    else{
        console.log("bruh")
        return false;
    }
}

//insert new Question to DB
async function insertNewQuestion(newQuestion){
    if(newQuestion){
        let [result, metadata] = await conn.query(
            `insert into question(id, kalimat_pertanyaan, pilihan_jawaban_a, pilihan_jawaban_b, jawaban_benar, skor, id_modul) values(:id, :kalimat_pertanyaan, :pilihan_jawaban_a, :pilihan_jawaban_b, :jawaban_benar, :skor, :id_modul)`,
            {
                replacements:{
                    id: newQuestion.id,
                    kalimat_pertanyaan:newQuestion.kalimat_pertanyaan,
                    pilihan_jawaban_a:newQuestion.pilihan_jawaban_a, 
                    pilihan_jawaban_b:newQuestion.pilihan_jawaban_b,
                    jawaban_benar: newQuestion.jawaban_benar,
                    skor: newQuestion.skor,
                    id_modul: newQuestion.id_modul
                }
            }
        )
        return (result != null);
    }
    else{
        console.log("bruh")
        return false;
    }
}

//get Module details from DB from Module ID
async function getModuleByID(id){
    let [result, metadata] = await conn.query(
        `select * from module where id = :id`,{
            replacements:{
                id:id
            }
        }
    )
    return result[0];
}

//get account details from DB by Module ID
async function getCreatorAccountByID(id){
    let [result, metadata] = await conn.query(
        `select * from account where id = :id`,{
            replacements:{
                id:id
            }
        }
    )
    return result[0];
}

//get all questions related to module
async function getQuestionsByModuleID(id){
    let [result, metadata] = await conn.query(
        `select * from question where id_modul = :id`,{
            replacements:{
                id:id
            }
        }
    )
    return result;
}

//get all question from ID
async function getQuestionByID(id){
    let [result, metadata] = await conn.query(
        `select * from question where id = :id`,{
            replacements:{
                id:id
            }
        }
    )
    return result[0];
}

//authenticate module password
async function checkPassword(id, password){
    let account = await getCreatorAccountByID(id);
    console.log(account);
    console.log(password);
    if(account.password != password){
        return false;
    }
    else{
        return true;
    }
}

//get all result from a user answers
async function getAllResult(id){
    let [result, metadata] = await conn.query(
        `select modul_id as id, total_jawaban_benar, skor from answer where acc_id = :id`,{
            replacements:{
                id:id
            }
        }
    )
    console.log(result);
    return result;
}

//answering to module questions
async function answerModule(id, answer, account){
    let modulDetail = await getModuleByID(id);
    let modulQuestions = await getQuestionsByModuleID(id);
    let question = modulQuestions[0];
    let skor = 0;
    let jawaban_benar = 0;
    let status = false;
    if(question.jawaban_benar==answer){
        console.log("betul")
        skor += question.skor;
        jawaban_benar++;
        status = true;
    }
    let newAnswer = {
        acc_id : account.id,
        modul_id : modulDetail.id,
        total_jawaban_benar : jawaban_benar,
        skor : skor
    }
    //insert DB
    let [result, metadata] = await conn.query(
        `insert into answer(acc_id, modul_id, total_jawaban_benar, skor) values(:acc_id, :modul_id, :total_jawaban_benar, :skor)`,
        {
            replacements:{
                acc_id:newAnswer.acc_id,
                modul_id:newAnswer.modul_id,
                total_jawaban_benar:newAnswer.total_jawaban_benar,
                skor: newAnswer.skor
            }
        }
    )

    let template = {
        message: `Berhasil menjawab modul ${modulDetail.nama_modul}, skor anda ${skor}`,
        pengisi: account.id,
        hasil: {
            pertanyaan: question.kalimat_pertanyaan,
            jawaban_benar: question.jawaban_benar,
            skor: question.skor
        }
    }

    return template;

}

//no 1
app.post("/api/accounts", async (req,res)=>{
    const schema = Joi.object({
        email: Joi.string().email().required().external(isUnique),
        nama_lengkap: Joi.string().min(2).required(),
        nomor_telepon: Joi.string().pattern(/^[0-9]+$/).min(8).max(10).required(),
        password: Joi.string().min(8).required(),
        confirm_password: Joi.string().required().valid(Joi.ref('password'))
    })
    try {
        await schema.validateAsync(req.body);
    } catch (error) {
        return res.status(403).send(error.toString())
    }

    let newID = await generateID();

    let newAcc = {
        id: newID,
        ...req.body
    }

    delete newAcc.confirm_password;

    let noProblems = await insertNewAccount(newAcc);
    if(noProblems){
        return res.status(201).send(newAcc);
    }
    else{
        return res.status(400).send({msg: "Error inserting to database"});
    }

})

//no 2
app.post("/api/modules", async (req,res)=>{
    const schema = Joi.object({
        acc_id: Joi.string().required().external(AccountExists),
        nama_modul: Joi.string().min(2).required(),
        password: Joi.string().pattern(/^[A-Za-z0-9]*$/).min(5).max(5),
        confirm_password: Joi.string().valid(Joi.ref('password'))
    })

    try {
        await schema.validateAsync(req.body);
    } catch (error) {
        return res.status(403).send(error.toString())
    }

    let newID = await generateModuleID();

    let newModule = {
        id: newID,
        ...req.body
    }

    delete newModule.confirm_password;

    let noProblems = await insertNewModule(newModule);
    if(noProblems){
        return res.status(201).send(newModule);
    }
    else{
        return res.status(400).send({msg: "Error inserting to database"});
    }

})

//no 3
app.post("/api/modules/add_question/:module_id", async (req,res)=>{
    const paramSchema = Joi.object({
        module_id: Joi.string().required().external(ModuleExists)
    })

    const bodySchema = Joi.object({
        password: Joi.string().required(),
        kalimat_pertanyaan: Joi.string().required(),
        pilihan_jawaban_a: Joi.string().pattern(/^[a-z0-9]+([-_\s]{1}[a-z0-9]+)*$/i).required(), //alphanum() returns invalid for white spaces?
        pilihan_jawaban_b: Joi.string().pattern(/^[a-z0-9]+([-_\s]{1}[a-z0-9]+)*$/i).required(), //alphanum() tidak valid untuk spasi
        jawaban_benar: Joi.number().valid(1,0).required(),
        skor: Joi.number().min(1).max(100).required()
    })

    try {
        await paramSchema.validateAsync(req.params);
    } catch (error) {
        return res.status(403).send(error.toString())
    }

    try {
        await bodySchema.validateAsync(req.body);
    } catch (error) {
        return res.status(403).send(error.toString())
    }

    let newID = await generateQuestionID();

    let newQuestion = {
        id: newID,
        ...req.body,
        id_modul: req.params.module_id
    }

    let noProblems = await insertNewQuestion(newQuestion);
    if(noProblems){
        let modulDetail = await getModuleByID(newQuestion.id_modul);
        let modulQuestions = await getQuestionsByModuleID(newQuestion.id_modul);
        let moduleCreator = await getCreatorAccountByID(modulDetail.pembuat_modul);
        let Module = {
            id: modulDetail.id,
            pembuat_modul: moduleCreator.nama_lengkap,
            nama_modul: modulDetail.nama_modul,
            pertanyaan: modulQuestions
        }
        return res.status(201).send(Module);
    }
    else{
        return res.status(400).send({msg: "Error inserting to database"});
    }

})

//no 4
app.get("/api/modules/:module_id", async (req,res)=>{
    const paramSchema = Joi.object({
        module_id: Joi.string().required().external(ModuleExists)
    })

    try {
        await paramSchema.validateAsync(req.params);
    } catch (error) {
        return res.status(404).send({msg:"Module tidak ditemukan"})
    }

    let id_modul = req.params.module_id;

    let modulDetail = await getModuleByID(id_modul);
    let modulQuestions = await getQuestionsByModuleID(id_modul);
    let moduleCreator = await getCreatorAccountByID(modulDetail.pembuat_modul);
    let Module = {
        id: modulDetail.id,
        pembuat_modul: moduleCreator.nama_lengkap,
        nama_modul: modulDetail.nama_modul,
        pertanyaan: modulQuestions
    }
    return res.status(200).send(Module);

})

//no 5
app.post("/api/accounts/answer_module/:module_id", async (req,res)=>{
    const paramSchema = Joi.object({
        module_id: Joi.string().required().min(5).max(5).external(ModuleExists)
    })

    const bodySchema = Joi.object({
        acc_id: Joi.string().min(5).max(5).required(),
        password: Joi.string().min(8).required(),
        jawaban: Joi.number().valid(1,0).required(),
    })

    try {
        await paramSchema.validateAsync(req.params);
    } catch (error) {
        return res.status(403).send(error.toString())
    }

    try {
        await bodySchema.validateAsync(req.body);
    } catch (error) {
        return res.status(403).send(error.toString())
    }

    let validAuth = await checkPassword(req.body.acc_id, req.body.password);
    if(!validAuth) return res.status(404).send({message: "Password Salah!"});

    let account = await getCreatorAccountByID(req.body.acc_id);

    let hasil = await answerModule(req.params.module_id, req.body.jawaban,account);
    return res.status(200).send(hasil);
})

//no 6
app.get("/api/accounts/result/:id", async (req,res)=>{
    const paramSchema = Joi.object({
        id: Joi.string().external(AccountExists)
    })

    try {
        await paramSchema.validateAsync(req.params);
    } catch (error) {
        return res.status(403).send(error.toString())
    }

    let hasil_kerja = await getAllResult(req.params.id);

    let template = {
        id: req.params.id,
        hasil_kerja:hasil_kerja
    }

    return res.status(200).send(template);

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