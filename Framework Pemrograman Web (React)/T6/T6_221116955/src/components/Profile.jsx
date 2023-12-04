import { useState } from "react"
import { useEffect } from "react"
import { useForm } from "react-hook-form";
import client from "../client";

export default function Profile(){
    
    const [mode, setMode] = useState(false);

    useEffect(() => {
    }, [mode])

    const {register, handleSubmit, reset, formState:{errors}} = useForm()

    useEffect(() => {
    }, [mode])

    const [user, setUser] = useState(
        {
            email: localStorage.getItem("email"),
            nama_depan: localStorage.getItem("nama").split(" ")[0],
            nama_belakang: localStorage.getItem("nama").split(" ")[1],
            username: localStorage.getItem("username"),
            password: localStorage.getItem("password")
        }
    );

    async function updateProfile(data){
        if (data.password != data.confirm) {
            alert("password dan confirm password tidak sama")
            errors.password.message = "password dan confirm password harus sama";
            errors.confirm.message = "password dan confirm password harus sama";
            return
        }
        data.nama = data.nama_depan + " " + data.nama_belakang;
        console.log(data);
        const url = '/update?'+'email='+data.email+'&password='+data.password+'&nama='+data.nama+'&username='+user.username;
        try{
            console.log(url);
            const response = await client.put(url);
            if(response.status === 200){
                alert("Profile Updated!")
                localStorage.setItem("email", data.email);
                localStorage.setItem("nama", data.nama);
                localStorage.setItem("username", data.username);
                localStorage.setItem('password', data.password);
                return
            }
        }
        catch(error){
            alert(error)
        }
    }

    return(
        <>
            <div className="container-fluid justify-content-center align-items-center">
                <h1 className="mb-4 text-center justify-content-center align-items-center">Profile</h1>
                <div className="row container-fluid justify-content-center align-items-center">
                    <div className="col-6 justify-content-center align-items-center">
                        <form onSubmit={handleSubmit(updateProfile)}>
                            <label>Nama</label><br />
                            <input type="text" {...register('nama_depan', {required:{value:true, message:"Nama depan tidak boleh kosong"}})} onChange={(e)=>{
                                setUser({...user, nama_depan:e.target.value})
                            }} value={user.nama_depan} className="mb-3"/> <input type="text" {...register("nama_belakang")} value={user.nama_belakang} 
                            onChange={(e)=>{
                                setUser({...user, nama_belakang:e.target.value})
                            }}
                            className="mb-3"/> <br />
                            
                            <label>Username</label><br />
                            <input type="text" {...register("username")} value={user.username} disabled className="mb-3"/> <br />
                            
                            <label>Email</label><br />
                            <input type="text" {...register("email", {required:{value:true, message:"Email tidak boleh dikosongi"}})} value={user.email} onChange={(e)=>{
                                setUser({...user, email:e.target.value})
                            }} className="mb-3"/> <br />
                            
                            {
                                mode ? 
                                <>
                                    <label>Password </label><br />
                                    <input type="password" {...register("password", {required:{value:true, message:"Password tidak boleh kosong"}})} value={user.password} 
                                    onChange={(e)=>{
                                        setUser({...user, password:e.target.value})
                                    }}className="mb-3"/> <br />
                                    <label>Confirm Password </label><br />
                                    <input type="password" {...register("confirm", {required:{value:true, message:"Confirm Password tidak boleh kosong"}})} className="mb-3"/> <br />
                                </>
                                :
                                <>
                                    <label>Password </label><br />
                                    <input type="password" {...register("password")} value={user.password} disabled className="mb-3"/> <br />
                                    <button className="btn btn-primary" onClick={() => setMode(!mode)}>Change Mode</button>
                                </>
                            }
                            <br />
                            <button type="submit" className="btn btn-primary mt-3">Save Changes</button>
                        </form>
                    </div>
                </div>
            </div>
        </>
    )
}