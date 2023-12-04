import { Link } from 'react-router-dom';
import {useForm} from "react-hook-form"
import { useNavigate } from 'react-router-dom';
import client from '../client';

export default function Login(){

    const {register, handleSubmit, reset, formState:{errors}} = useForm()
    const navigate = useNavigate();

    async function signIn(data){
        const url = '/login?email='+data.email+'&password='+data.pass
        try{
            const response = await client.post(url);
            if(response.status === 200){
                alert("Berhasil masuk!")
                console.log(response)
                localStorage.setItem("email", response.data.user.email);
                localStorage.setItem("nama", response.data.user.nama);
                localStorage.setItem("username", response.data.user.username);
                localStorage.setItem('password', response.data.user.password);
                navigate('/');
                return
            }
        }
        catch(error){
            alert(error.response.data.msg)
        }
    } 

    return (
        <>
            <div className="container">
                <h1 className="mb-4">Hello, Welcome Back</h1>
                <form onSubmit={handleSubmit(signIn)}>
                    <label>Email </label><br />
                    <input type="text" placeholder="Email" {...register("email", {required:{value:true, message:"Email harus diisi!"}})} className="mb-3"/> <br />
                    <span style={{color:"red"}}>{errors?.email?.message}</span><br />
                    <label>Password </label><br />
                    <input type="password" placeholder="Password" {...register("pass", {required:{value:true, message:"Password harus diisi!"}})} className="mb-3"/> <br />
                    <span style={{color:"red"}}>{errors?.pass?.message}</span><br />
                    
                    <button type='submit'>Masuk</button>                    
                </form>
                <div>Lupa Password?</div>
                <div>Belum punya akun?  <Link to={"/register"}>Daftar Sini</Link> </div>
            </div>
        </>
    )
}