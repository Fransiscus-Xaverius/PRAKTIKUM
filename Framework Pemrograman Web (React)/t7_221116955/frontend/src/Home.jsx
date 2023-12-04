import { useLoaderData } from "react-router-dom"

export default function Home(){

    const data = useLoaderData()

    console.log(data)

    return (
        <>
            <div className="container-fluid">
                <div className="row">
                    <div className="col">
                        <h1>Last Match</h1>
                        <table>
                            <thead style={{border:"1px solid black", width:"500px"}}>
                                <tr >
                                    <th style={{border:"1px solid black", width:"200px"}} className="text-center">Home</th>
                                    <th style={{border:"1px solid black"}} className="text-center">Score</th>
                                    <th style={{border:"1px solid black", width:"200px"}} className="text-center">Away</th>
                                </tr>
                            </thead>
                            <tbody style={{border:"1px solid black"}}>
                                <tr>
                                    <td style={{border:"1px solid black"}} className="text-center">{data.lastmatch.team_home}</td>
                                    <td style={{border:"1px solid black"}} className="text-center">{data.lastmatch.score_home} - {data.lastmatch.score_away}</td>
                                    <td style={{border:"1px solid black"}} className="text-center">{data.lastmatch.team_away}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <hr />
                <div className="row">
                    <div className="col">
                        <h1>Top 3 Teams</h1>
                        <table>
                            <thead style={{border:"1px solid black", width:"500px"}}>
                                <tr >
                                    <th style={{border:"1px solid black", width:"200px"}} className="text-center">Team</th>
                                    <th style={{border:"1px solid black"}} className="text-center">Points</th>
                                </tr>
                            </thead>
                            <tbody style={{border:"1px solid black"}}>
                                {data.mostpoints.map((team, index) => {
                                    let points = team.record.win*5 + team.record.draw*2
                                    console.log(points)
                                    return(
                                        <tr>
                                            <td style={{border:"1px solid black"}} className="text-center">{team.name}</td>
                                            <td style={{border:"1px solid black"}} className="text-center">{points}</td>
                                        </tr>
                                    )
                                })}
                            </tbody>
                        </table>
                    </div>
                </div>
                <hr />
                <div className="row">
                    <div className="col">
                        <h1>Top 3 Players</h1>
                        <table>
                            <thead style={{border:"1px solid black", width:"500px"}}>
                                <tr >
                                    <th style={{border:"1px solid black", width:"200px"}} className="text-center">Player</th>
                                    <th style={{border:"1px solid black"}} className="text-center">Goals</th>
                                </tr>
                            </thead>
                            <tbody style={{border:"1px solid black"}}>
                                {data.mostgoals.map((player, index) => {
                                    return(
                                        <tr>
                                            <td style={{border:"1px solid black"}} className="text-center">{player.name}</td>
                                            <td style={{border:"1px solid black"}} className="text-center">{player.goals}</td>
                                        </tr>
                                    )
                                })}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </>
    )
}