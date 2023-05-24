const express = require("express");
const app = express();
const port = 3000;

app.use(express.urlencoded({ extended: true}));

const user_list = [];
const pinjaman_list = [];

//no 1

app.post("/api/register",(req,res)=>{
    if(!req.body.password||!req.body.confirm_password||!req.body.nama_user||!req.body.tanggal_lahir){
        return res.status(404).send({message: "Missing data."});
    }
    else{
        const pass = req.body.password;
        const confirm = req.body.confirm_password;
        if(pass==confirm){
            const newUser={
                user_id: "",
                nama_user: req.body.nama_user,
                tanggal_lahir: req.body.tanggal_lahir,
                password: req.body.password
            }
            if(newUser.tanggal_lahir.length!=10){
                return res.status(400).send({message: "Format tanggal lahir tidak sesuai"})
            }
            else{
                if(newUser.tanggal_lahir.charAt(2)!='/'&&newUser.tanggal_lahir.charAt(5)!='/'){
                    return res.status(400).send({message: "Format tanggal lahir tidak sesuai"});
                }
                else{
                    let num = 0;
                    for (let index = 0; index < newUser.tanggal_lahir.length; index++) {
                        const element = newUser.tanggal_lahir.charAt(index);
                        if(element >= '0' && element <= '9'){
                            num++;
                        }
                    }
                    if(num==8){
                        let temp = user_list.length;
                        temp++;
                        let satuan = temp%10;
                        let puluhan = (temp/10)%10;
                        let ratusan = temp/100;
                        satuan = parseInt(satuan);
                        puluhan = parseInt(puluhan);
                        ratusan = parseInt(ratusan);
                        const userid = "U"+ratusan.toString()+puluhan.toString()+satuan.toString();
                        newUser.user_id = userid;
                        newUser.status = "Not Verified";
                        user_list.push(newUser);
                        return res.status(201).send({
                            user_id: newUser.user_id,
                            nama_user: newUser.nama_user,
                            tanggal_lahir: newUser.tanggal_lahir,
                            status: newUser.status
                        });
                    }
                    else{
                        return res.status(400).send({message: "Format tanggal lahir tidak sesuai"});
                    }
                }
            }
        }
        else{
            return res.status(404).send({
                message: "Confirm Password tidak cocok"
            });
        }
    }
})

//no 2

app.put("/api/verify/:id_user", (req,res) =>{
    if(req.body.password&&req.params.id_user){
        const uid = req.params.id_user;
        const pass = req.body.password;
        let found = false;
        let tar = null;
        for (let index = 0; index < user_list.length; index++) {
            const element = user_list[index];
            if(element.user_id==uid){
                found = true;
                tar = element;
            }
            console.log(element.user_id);
        }
        if(found){
            if(tar.password==pass){
                tar.status = "Verified";
                return res.status(200).send({msg: `User ${tar.user_id} berhasil melakukan verifikasi`});
            }
            else{
                return res.status(400).send({msg:"Password salah"});
            }
        }
        else{
            return res.status(404).send({msg: "User tidak terdaftar"});
        }
    }
    else{
        return res.status(404).send({message: "Invalid Request. Password/User ID args not found"});
    }
});

function toIDR(val){
    val = parseInt(val).toLocaleString('en-US',{style: 'currency',currency: 'IDR'});
    val = val.toString().replace('IDR', 'Rp.');
    val = val.toString().replace(',','.');
    return val;
}

function getBunga(val){
    let bunga;
    if(val>10000000){
        bunga = 0.1;
    }
    else if(val<=999999){
        bunga = 0.05;
    }
    else{
        bunga = 0.075;
    }
    return bunga;
}

//no 3

app.get("/api/loan/estimation",(req,res)=>{
    let pinjaman = req.query.pinjaman;
    if(pinjaman){
        let val = parseInt(pinjaman);
        let bunga;
        bunga = getBunga(val);
        
        let hasil = val*bunga;
        hasil+=val;
        hasil = toIDR(hasil);
        val = toIDR(val);
        
        return res.status(200).send({
            bunga: (bunga*100)+"%",
            pinjaman: val,
            pembayaran: hasil
        });

    }
    else{
        return res.status(404).send("Query not found.")
    }
});

//no 4

app.post("/api/loan",(req,res)=>{
    const password = req.body.password;
    const user_id = req.body.id_user;
    let pinjaman = req.body.pinjaman;
    if(password&&user_id&&pinjaman){
        let found = false;
        let tar = null;
        for (let index = 0; index < user_list.length; index++) {
            const element = user_list[index];
            if(element.user_id==user_id){
                found = true;
                tar = element;
            }
            console.log(element.user_id);
        }
        if(found){
            if(tar.password==password){
                if(tar.status=="Verified"){
                    let temp = pinjaman_list.length;
                    temp++;
                    let satuan = temp%10;
                    let puluhan = (temp/10)%10;
                    let ratusan = temp/100;
                    satuan = parseInt(satuan);
                    puluhan = parseInt(puluhan);
                    ratusan = parseInt(ratusan);
                    let total = pinjaman*getBunga(pinjaman);
                    total=parseInt(total)+parseInt(pinjaman);
                    newLoan = {
                        id_pinjaman: "L"+ratusan.toString()+puluhan.toString()+satuan.toString(),
                        nama_user: tar.nama_user,
                        id_user: tar.user_id,
                        pinjaman: pinjaman,
                        bunga: getBunga(pinjaman)*100+"%",
                        jumlah_pembayaran: total,
                        status: "Not Paid"
                    };
                    pinjaman_list.push(newLoan);
                    return res.status(200).send({
                        id_pinjaman: newLoan.id_pinjaman,
                        nama_user: tar.nama_user,
                        pinjaman: toIDR(pinjaman),
                        bunga: newLoan.bunga,
                        jumlah_pembayaran: toIDR(newLoan.jumlah_pembayaran),
                        status: newLoan.status
                    });
                }
                else{
                    return res.status(400).send({msg:"User Belum terverifikasi"});
                }
            }
            else{
                return res.status(400).send({msg:"Password Salah"});
            }
        }
        else{
            return res.status(404).send({msg:"User tidak terdaftar"});
        }   
    }
    else{
        return res.status(404).send({msg:"Format input salah"});
    }
});

//no 5

app.put("/api/loan/:id_pinjaman/pay",(req,res)=>{
    const id_pinjaman = req.params.id_pinjaman;
    const id_user = req.body.id_user;
    const password = req.body.password;
    if(id_pinjaman&&id_user&&password){
        let found = false;
        let found2 = false;
        let tar = null;
        let temp_pinjaman = null;
        for (let index = 0; index < user_list.length; index++) {
            const element = user_list[index];
            if(element.user_id==id_user){
                found = true;
                tar = element;
            }
        }
        for (let index = 0; index < pinjaman_list.length; index++) {
            const element = pinjaman_list[index];
            if(element.id_pinjaman==id_pinjaman){
                found2 = true;
                temp_pinjaman = element;
            }
        }
        if(found&&found2){
            if(temp_pinjaman.id_user!=tar.user_id){
                return res.status(400).send({msg:"User bukan pemilik pinjaman"});
            }
            else{
                
            }
        }
        else{
            if(!found2){
                return res.status(404).send({msg:"Pinjaman tidak terdaftar"});
            }
            else{
                return res.status(404).send({msg:"User tidak terdaftar"});
            }
        }
    }
    else{
        return res.status(404).send({msg:"Input tidak sesuai format"})
    }
});

app.listen(port,()=>console.log(`Listening to port ${port}`));