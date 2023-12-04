import { useLoaderData, useParams } from "react-router-dom"
import {React, useEffect, useState} from 'react'
import client from "../client";
import { NavLink, Link } from "react-router-dom";
import {useForm} from "react-hook-form"
import { useNavigate } from "react-router-dom";

export default function Overview() {
    const { story_id } = useParams()
    const [judul, setJudul] = useState("")
    const {register, handleSubmit, reset, formState:{errors}} = useForm()
    const navigate = useNavigate();

    const checkID = (obj) => {
        return obj.id == story_id
    }
    let stories = useLoaderData();
    // console.log(stories);
    let story = stories.find(checkID);
    console.log(story)
    


    useEffect(() => {
        setJudul(story.nama);
    }, [])

    async function changeImage(data){
        const url = 'stories/updateimg?poster='+data.poster+'&id='+story_id;
        try{
            const response = await client.put(url);
            if(response.status === 200){
                alert("Berhasil mengubah poster!")
                story.poster = data.poster;
                return
            }
        }
        catch(error){
            alert(error)
        }
    }

    async function deleteSelf(){
        try {
            const url = "/stories?id=" + story_id;
            const response = await client.delete(url);
            if (response.status === 200) {
                alert("Berhasil menghapus stories!")
                navigate("/stories");
                return;
            }
        } catch (error) {
            alert(error);
        }
    }

    async function updateNama(data){
        const url = '/stories/updatenama?nama='+judul+'&id='+story_id;
        try{
            const response = await client.put(url);
            if(response.status === 200){
                alert("Berhasil mengubah nama!")
                story.nama = judul;
                return
            }
        }
        catch(error){
            alert(error)
        }
    }

    return (
        <>
            <div className="container-fluid p-4 display-flex justify-content-center align-items-center">
                <div className="row">
                    <div className="col-6">
                        <h1>{story.nama}</h1>
                    </div>
                    <div className="col-6 my-auto d-flex flex-row-reverse">
                        <NavLink to={"/stories/" + story_id + "/characters"} className="btn btn-secondary" style={{marginLeft: "10px"}}>Characters</NavLink>
                        <NavLink to={"/stories/" + story_id + "/overview"} className="btn btn-secondary">Overview</NavLink>
                    </div>
                </div>
                <div className="row container-fluid p-4 d-flex justify-content-center align-items-center">
                    <div className="col-6 p-4 rounded" style={{width:"50rem", height:"35rem", outline:"1px solid black"}}>
                        <div className="row">
                            <div className="col-6">
                                <form onSubmit={handleSubmit(updateNama)}>
                                    <input style={{width:"80%", fontSize:"20px"}} {...register("nama") } value={judul} onChange={(e)=>{
                                        setJudul(e.target.value)
                                    }} type='text' name='name'/>
                                    <button type="submit" className="btn btn-secondary">Edit</button><br />
                                </form>
                            </div>
                            <div className="col-6 d-flex flex-row-reverse">
                                <button className="btn btn-danger" onClick={()=>{deleteSelf()}}>Delete</button>
                            </div>
                        </div>
                        <div className="row">
                            <div className="col-12 text-center">
                                <div className="row d-flex justify-content-center align-items-center">
                                {
                                    story &&
                                    <>
                                        <img src={story.poster} style={{width:"15rem"}} alt="" />
                                        <br />
                                    </>
                                }
                                </div>
                                <div className="row">
                                    <form onSubmit={handleSubmit(changeImage)}>
                                        <label>URL</label><br />
                                        <input type="text" {...register("poster")} className="mb-3" style={{width:"600px"}}/> <br />
                                        <button className="btn btn-primary" type="submit">Change Image</button>
                                    </form>
                                </div>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}