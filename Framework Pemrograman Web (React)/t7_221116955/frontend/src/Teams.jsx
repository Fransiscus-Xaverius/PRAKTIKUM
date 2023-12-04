import React, { useEffect } from 'react';
import { useState } from 'react';
import { useLoaderData } from 'react-router-dom';
import client from './client';
import { useForm, useFieldArray, set } from 'react-hook-form';


export default function Teams(){

    const data = useLoaderData().data;
    console.log(data);

    const [addTeam, setAddTeam] = useState(false);
    const [addedTeam, setAddedTeam] = useState(0);

    let initial_state = [];

    const [newplayers, setNewPlayers] = useState(initial_state);

    const {register, handleSubmit, reset, formState:{errors}} = useForm();

    const addNewPlayer = () => {
        setNewPlayers([...newplayers, {nama:"", nomor:"", posisi:"", nationalitiy:""}]);
    }

    const add = async (data) => {
        try {
            let url = "http://localhost:3000/newTeam?nama="+data.nama+"&coach="+data.coach;
            let res = await client.post(url);
            let team_id = res.data.id;
            console.log(team_id);
            alert("Berhasil menambahkan tim baru!");
            window.location.reload();
        } catch (error) {
            alert("Error menambahkan team baru")
            console.log(error)
        }
    }

    return(
        <>
            <div className="container-fluid">
                <div className="row">
                    <div className="col">
                        <button className="btn btn-primary" style={{width:"200px"}} onClick={()=>{reset();setNewPlayers(initial_state);setAddTeam(!addTeam)}}>{addTeam && "Cancel Add Team"}{!addTeam && "Add Team"}</button>
                    </div>
                </div>
                {addTeam && (
                    <div className="row">
                        <form onSubmit={handleSubmit(add)}>
                            <label>
                                Nama Tim:
                                <input type="text" {...register('nama')} />
                            </label>
                            <br />
                            <label>
                                Coach:
                                <input type="text" {...register('coach')}/>
                            </label>
                            <br />
                            
                            <button className='btn btn-success' type="submit">Submit</button>
                        </form>
                    </div>
                )}
                <hr />
                <h1>Team List</h1>
                <table style={{display:"block"}}>
                    <thead>
                        <tr style={{border:"1px solid black"}} className="table-success">
                            <th className='text-center' style={{border:"1px solid black"}} scope="col">NAMA</th>
                            <th className='text-center' style={{border:"1px solid black"}} scope="col">COACH</th>
                            <th className='text-center' style={{border:"1px solid black"}} scope="col">WIN</th>
                            <th className='text-center' style={{border:"1px solid black"}} scope="col">LOSE</th>
                            <th className='text-center' style={{border:"1px solid black"}} scope="col">DRAW</th>
                            <th className='text-center' >Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {data.map((team, index) => {
                            return(
                                <tr>
                                    <td className='text-center' style={{border:"1px solid black", width:"100px"}}>{team.name}</td>
                                    <td className='text-center' style={{border:"1px solid black", width:"200px"}}>{team.coach}</td>
                                    <td className='text-center' style={{border:"1px solid black", width:"75px"}}>{team.record.win}</td>
                                    <td className='text-center' style={{border:"1px solid black", width:"75px"}}>{team.record.lose}</td>
                                    <td className='text-center' style={{border:"1px solid black", width:"75px"}}>{team.record.draw}</td>
                                    <td className="text-center" style={{border:"1px solid black"}}><button className="btn btn-primary m-1">Update</button><button className="btn btn-danger m-1">Delete</button></td>
                                </tr>
                            )
                        })}
                    </tbody>
                </table>
            </div>
            
        </>
    )
}