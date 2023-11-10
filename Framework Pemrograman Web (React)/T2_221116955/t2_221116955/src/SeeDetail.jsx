export default function SeeDetail(data){

    let color;
    if(data.data[data.curdata].difficulty == "beginner"){   
        color = "#32de84";
    }
    else if(data.data[data.curdata].difficulty == "intermediate"){  
        color = "orange";
    }
    else{
        color = "red";
    }

    console.log(color);

    let menuData = data.data[data.curdata].menu;

    const DeleteClick = () => {
        data.removePlan(data.curdata);
    }

    const UpdateClick = () =>{
        data.updatePlan(data.curdata);
    }

    return (
        <>
            <div className="container-fluid p-0">
                <div className="row m-2">
                    <div className="col-8">
                        <h3 className="text-start fw-bold">{data.data[data.curdata].name}</h3>
                    </div>
                    <div className="col">
                        <button className="btn btn-danger text-white" onClick={DeleteClick}>
                            Delete
                        </button>
                        <button className="btn btn-primary text-white" onClick={UpdateClick}>
                            Edit
                        </button>
                    </div>
                </div>
                <div className="row m-0">
                    <div className="col-2 ml-1 ">
                    <p className="fw-semibold">Difficulty: </p>
                    </div>
                    <div className="col ml-1" >
                        <div className="rounded text-white" style={{backgroundColor:color, height:"30px", width:"100px"}}>
                        {data.data[data.curdata].difficulty}
                        </div>
                    </div>
                </div>
                <div className="row m-0">
                    <div className="col ml-1 ">
                        <p className="text-start fw-semibold">Duration Range: {data.data[data.curdata].durationMin} to {data.data[data.curdata].durationMin} Minutes</p>
                    </div>
                </div>
                <div className="row m-0">
                    <div className="col ml-1 ">
                        <p className="text-start fw-semibold">Gender: {data.data[data.curdata].gender}</p>
                    </div>
                </div>
                <div className="row m-0">
                    <div className="col">
                        <p className="fw-semibold text-start">Menu:</p>
                    </div>
                </div>
                <div className="row m-0">
                    {
                            menuData.map((item, index) => {
                                return(
                                    <div className="row p-2 m-1" style={{border:"1px solid black", borderRadius:"25px"}}>
                                        <div className="col-2">
                                            <p className="text-start m-0">{item.set} Set</p>
                                        </div>
                                        <div className="col-8">
                                            <p className="text-start m-0">{item.name}</p>
                                        </div>
                                        <div className="col-2">
                                            <p className="text-start m-0">{item.reps} {item.repType}</p>
                                        </div>
                                    </div>
                                )
                            })
                        }
                </div>
            </div>
        </>
    )
}