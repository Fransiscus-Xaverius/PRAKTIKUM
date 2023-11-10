import ExperienceItem from "./ExperienceItem"
export default function Experiences({experience, addExperience, removeExperience, changeExp, register, errors}){
    return (
        <>
            <div className="container-fluid bg-white p-5 rounded" style={{width:"60%"}}>
                <h6 style={{fontWeight:"bold"}}>Experiences</h6>
                <div className="col container-fluid d-flex">
                    <div className="row">
                    {
                        experience.map((item,index) =>{
                            return (
                                <ExperienceItem key={index} exp={item} removeExperience={removeExperience} idx={index} changeExp={changeExp} register={register} errors={errors}/>
                            )
                        })
                    }
                    </div>
                </div>
                <div className="col">
                    <div className="container-fluid d-flex justify-content-end ">
                        <button className="btn btn-primary" onClick={addExperience}>Add</button>
                    </div>
                </div>
            </div>
        </>
    )
}