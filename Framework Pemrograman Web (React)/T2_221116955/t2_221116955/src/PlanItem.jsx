import female from './assets/female.png';
import male from './assets/male.png';
import intersex from './assets/intersex.png';
import duration from './assets/duration.png';

export default function PlanItem(data){
    let img;
    if(data.gender == "female"){
        img = female;
    }
    else if(data.gender == "male"){
        img = male;
    }
    else{
        img = intersex;
    }

    const itemClick = () => {
        console.log("clicked" + data.index);
        data.onclick(data.index);
    }

    return (
        <div className="container d-flex justify-content-start align-items-center" style={{borderBottom: "1px solid black"}} onClick={itemClick}>
            <div className="container row">
                <div className="col-10 justify-content-start p-0">
                    <p className="fw-semibold text-start m-0" style={{fontSize:"17px"}}>{data.name}</p>
                    <div className="container-flex d-flex row m-0 p-0 justify-content-start align-items-start">
                    <p className="text-start m-0" style={{fontSize:"14px"}}>{data.difficulty}</p>
                        <div className="col-sm">
                            <img src={duration} alt="" style={{width:"12%", height:"15%"}}/>
                        </div>
                        <div className="col-sm">
                            <p className="text-start m-0" style={{fontSize:"14px"}}>{data.durationMin} - {data.durationMax} minutes</p>
                        </div>
                        <div className="col justify-content-end p-0">
                            <img src={img} alt="" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}