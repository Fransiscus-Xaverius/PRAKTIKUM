import { useLoaderData } from "react-router-dom"
import { useState } from "react";
import { useForm } from "react-hook-form";
import client from "./client";
export default function Players(){
    const dataAwal = useLoaderData();
    const data = dataAwal.players;
    const teams = dataAwal.teams;

    console.log(data)
    const [add, setAdd] = useState(false);

    const {register, handleSubmit, reset, formState:{errors}} = useForm();

    function checkName(name, team_name){
        return name==team_name;
    }

    const addPlayer = async (data) => {
        try {
            let team = teams.find(team => checkName(team.name, data.team));
            console.log(team);
            const url = "http://localhost:3000/player?name="+data.nama+"&age="+data.age+"&nationality="+data.nationality+"&number="+data.nomor+"&position="+data.position+"&team_id="+team._id;
            console.log(url);
            const response = await client.post(url);
            alert('Berhasil menambahkan player baru!');
            window.location.reload();
        } catch (error) {
            alert('Error menambahkan player baru');
        }
    }

    return (
        <>
            {!add && <button className="btn btn-success" onClick={()=>{setAdd(true)}}>Add Player</button>}
            {add && (
                
                    <div className="row">
                        <button className="btn btn-danger" style={{width:"auto"}} onClick={()=>{setAdd(false)}}>Cancel Add Player</button>
                        <form onSubmit={handleSubmit(addPlayer)}>
                            <label>
                                Nama Player:
                                <input type="text" {...register('nama')} />
                            </label>
                            <br />
                            <label>
                                Nomor:
                                <input type="number" {...register('nomor')}/>
                            </label>
                            <br />
                            <label>
                                Age:
                                <input type="number" {...register('age')}/>
                            </label>
                            <br />
                            <label>
                                Nationality:
                                <input type="text" {...register('nationality')}/>
                            </label>
                            <br />
                            <label>
                                Position:
                                <select {...register('position')} name="position" id="position">
                                    <option value="Goalkeeper">Goalkeeper</option>
                                    <option value="Defender">Defender</option>
                                    <option value="Midfielder">Midfielder</option>
                                    <option value="Forward">Forward</option>
                                </select>
                            </label>
                            <br />
                            <label>
                                Team:
                                <select {...register('team')} name="team" id="team">
                                    {teams.map((team, index) => {
                                        return(
                                            <option value={team.id}>{team.name}</option>
                                        )
                                    })}
                                </select>
                            </label>
                            
                            <button className='btn btn-success' type="submit">Submit</button>
                        </form>
                    </div>
            )}
            <hr />
            <h1>Player List</h1>
            <table>
                <thead>
                    <tr>
                        <th className="text-center" style={{border:"1px solid black", width:"200px"}}>Nama</th>
                        <th className="text-center" style={{border:"1px solid black", width:"100px"}}>Age</th>
                        <th className="text-center" style={{border:"1px solid black", width:"100px"}}>Nomor</th>
                        <th className="text-center" style={{border:"1px solid black", width:"200px"}}>Nationality</th>
                        <th className="text-center" style={{border:"1px solid black", width:"200px"}}>Team</th>
                        <th className="text-center" style={{border:"1px solid black"}}>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map((player, index) => {
                        return(
                            <tr>
                                <td className="text-center" style={{border:"1px solid black", width:"200px"}}>{player.name}</td>
                                <td className="text-center" style={{border:"1px solid black", width:"100px"}}>{player.age}</td>
                                <td className="text-center" style={{border:"1px solid black", width:"100px"}}>{player.number}</td>
                                <td className="text-center" style={{border:"1px solid black", width:"200px"}}>{player.nationality}</td>
                                <td className="text-center" style={{border:"1px solid black", width:"200px"}}>{player.team}</td>
                                <td className="text-center" style={{border:"1px solid black"}}><button className="btn btn-primary m-1">Update</button><button className="btn btn-danger m-1">Delete</button></td>
                            </tr>
                        )
                    })}
                </tbody>
            </table>
        </>
    )
}