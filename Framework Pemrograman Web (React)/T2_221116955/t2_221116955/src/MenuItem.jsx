export default function MenuItem({index, menu, onchange, removeMenu}){
    
    let set = menu[index].set;
    let name = menu[index].name;
    let reps = menu[index].reps;
    let repType = menu[index].repType;

    const changeSet = (e) => {  
        set = e.target.value;
        onchange(index, set, name, reps, repType);
    }

    const changeName = (e) => {
        name = e.target.value;
        onchange(index, set, name, reps, repType);
    }

    const changeReps = (e) => {
        reps = e.target.value;
        onchange(index, set, name, reps, repType);
    }

    const changeRepType = (e) => {
        repType = e.target.value;
        onchange(index, set, name, reps, repType);
    }

    return (
        <>
            <div className="container">
                <div className="row">
                    <div className="col-2 d-flex ">
                        <input className="m-1 rounded" type="text" name="set" id="" placeholder="1" style={{width:"50px", height:"30px"}} onChange={changeSet}/>
                        <p className="m-1">Set</p>
                    </div>
                    <div className="col d-flex">
                        <input className="m-1 rounded" type="text" name="name" id="" placeholder="Fast-Paced Walk" style={{width:"300px", height:"30px"}} onChange={changeName}/>
                    </div>
                    <div className="col d-flex justify-content-start align-items-start p-0">
                        <input className="m-1 rounded" type="text" name="name" id="" placeholder="10" style={{width:"50px", height:"30px"}} onChange={changeReps}/>
                        <select name="diff" className="m-1 rounded" id=""  style={{width:"70px", height:"30px"}} onChange={changeRepType}>
                            <option value="x">x</option>
                            <option value="mins">mins</option>
                        </select>
                        <button className="btn btn-transparent" onClick={()=>{removeMenu(index)}}>❌</button>
                    </div>
                </div>
            </div>
        </>
    )
}

