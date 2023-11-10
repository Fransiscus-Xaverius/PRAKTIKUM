import Joi from "joi"
import { useForm } from 'react-hook-form'
import { joiResolver } from '@hookform/resolvers/joi'


export default function AboutMe({register, errors, changeAboutme}){

    const change = (e) => {
        changeAboutme(e.target.value)
    }

    return (
        <div className="container-fluid bg-white p-5 rounded" style={{width:"60%"}}>
            <h6 style={{fontWeight:"bold"}}>About Myself</h6>
            <textarea name="" id="" cols="140" rows="10" {...register("aboutme")} onChange={change}></textarea>
            {errors.aboutme && <span style={{color:"red"}}>{errors.aboutme.message} <br /></span>}
        </div>
    )
}