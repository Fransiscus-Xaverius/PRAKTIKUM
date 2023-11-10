export default function ExperienceItem({exp, removeExperience, idx, changeExp, errors}){
    
    let title = exp.title;
    let place = exp.place;
    let description = exp.description;
    let start = exp.start;
    let end = exp.end;

    const changeTitle = (e) => {
        title = e.target.value;
        changeExp(idx, title, place, description, start, end)
    }

    const changePlace = (e) => {
        place = e.target.value;
        changeExp(idx, title, place, description, start, end)
    }

    const changeDescription = (e) => {
        description = e.target.value;
        changeExp(idx, title, place, description, start, end)
    }

    const changeStart = (e) => {
        start = e.target.value;
        changeExp(idx, title, place, description, start, end)
    }

    const changeEnd = (e) => {
        end = e.target.value;
        changeExp(idx, title, place, description, start, end)
    }

    return (
        <>
            <div className="container-fluid p-2">
                <div className="row d-flex">
                    <div className="col-5 d-flex">
                        <input type="text" name="exp_title" id="exp_title" placeholder="Title"style={{width:"100%"}} onChange={changeTitle}/>
                        {errors.exp && <span style={{color:red}}>{errors.exp.message}</span>}
                    </div>
                    <div className="col-5 d-flex">
                        <input type="text" name="exp_place" id="exp_place" placeholder="Place" style={{width:"100%"}} onChange={changePlace}/>
                    </div>
                    <div className="col">
                        <button className="btn" onClick={()=>{removeExperience(idx)}}>❌</button>
                    </div>
                </div>
                <div className="row d-flex pt-1">
                    <div className="row d-flex">
                        <div className="col-7 d-flex">
                            <input type="text" name="" id="description" placeholder="Description" style={{width:"100%"}} onChange={changeDescription}/>
                        </div>
                        <div className="col-2 d-flex justify-content-center">
                            <input type="text" name="description_start" id="description_start" placeholder="Start" onChange={changeStart}/>
                        </div>
                        <div className="col-2 d-flex justify-content-start">
                            <input type="text" name="description_end" id="description_end" placeholder="End" onChange={changeEnd}/>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}