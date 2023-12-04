import { useForm } from 'react-hook-form'
import { Link } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'
import client from '../client'

export default function Register(){
    
    const {register, handleSubmit, reset, formState:{errors}} = useForm()

    const navigate = useNavigate()

    async function signUp(data){
        if (data.password != data.confirm) {
            alert("password dan confirm password tidak sama")
            errors.password.message = "password dan confirm password harus sama";
            errors.confirm.message = "password dan confirm password harus sama";
            return
        }

        const url = '/register?'+'email='+data.email+'&password='+data.password+'&nama='+data.nama+'&username='+data.username;
        try{
            const response = await client.post(url);
            if(response.status === 201){
                alert("Berhasil mendaftar!")
                localStorage.setItem("email", data.email);
                localStorage.setItem("nama", data.nama);
                localStorage.setItem("username", data.username);
                localStorage.setItem('password', data.password);
                navigate('/');
                return
            }
        }
        catch(error){
            alert(error.response.data.msg)
        }
        
        
    }

    return(
        <>
            <div className="container">
                <h1 className="mb-4 text-center">Registration</h1>
                <form onSubmit={handleSubmit(signUp)}>
                    <div className="row">
                        <div className="col-6">
                            <label>Username</label><br />
                            <input type="text" {...register("username", {required:{value:true, message:"Username harus diisi!"}}) } placeholder="Username" className="mb-3"/> <br />
                            <span style={{color:"red"}}>{errors?.username?.message}</span><br />
                            <label>Email</label><br />
                            <input type="text" {...register("email", {required:{value:true, message:"Email harus diisi!"}}) } placeholder="Nama Lengkap" className="mb-3"/> <br />
                            <span style={{color:"red"}}>{errors?.email?.message}</span><br />
                            <label>Nama</label><br />
                            <input type="text" {...register("nama", {required:{value:true, message:"Nama harus diisi!"}})} placeholder="Nama Lengkap" className="mb-3"/> <br />
                            <span style={{color:"red"}}>{errors?.nama?.message}</span><br />
                            <label>Password </label><br />
                            <input type="password" {...register("password", {required:{value:true, message:"Password harus diisi!"}})} placeholder="Password" className="mb-3"/> <br />
                            <span style={{color:"red"}}>{errors?.password?.message}</span><br />
                            <label>Konfirmasi Password </label><br />
                            <input type="password" {...register("confirm",{required:{value:true, message:"Konfirmasi password harus diisi!"}})} placeholder="Konfirmasi Password" className="mb-3"/>
                            <br />
                            <span style={{color:"red"}}>{errors?.confirm?.message}</span><br />
                        </div>
                    </div>
                    <button type='submit'>Daftar</button>
                </form>
                <div>Sudah punya akun?  <Link to={"/login"}>Login</Link> </div>
            </div>
        </>
    )
}