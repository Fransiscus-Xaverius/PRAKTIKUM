import { useState } from "react";
export default function Education({setHighschool, setDiploma, setBachelor, setMaster, register, errors}){
    const [highschool_required, setHighschoolRequired] = useState(false);
    const [diploma_required, setDiplomaRequired] = useState(false);
    const [bachelor_required, setBachelorRequired] = useState(false);
    const [master_required, setMasterRequired] = useState(false);
    
    const [highschool_ans, setHighschoolAns] = useState("");
    const [highschool_start, setHighschoolStart] = useState("");
    const [highschool_end, setHighschoolEnd] = useState("");

    const [diploma_ans, setDiplomaAns] = useState("");
    const [diploma_start, setDiplomaStart] = useState("");
    const [diploma_end, setDiplomaEnd] = useState("");

    const [bachelor_ans, setBachelorAns] = useState("");
    const [bachelor_start, setBachelorStart] = useState("");
    const [bachelor_end, setBachelorEnd] = useState("");

    const [master_ans, setMasterAns] = useState("");
    const [master_start, setMasterStart] = useState("");
    const [master_end, setMasterEnd] = useState("");

    const changeHighschool_ans = (e) => {
        setHighschoolAns(e.target.value);
        let temp ={
            required:highschool_required,
            place:e.target.value,
            start:highschool_start,
            end:highschool_end
        }
        setHighschool(temp);
    }

    const changeHighschool_start = (e) => {
        setHighschoolStart(e.target.value);
        let temp ={
            required:highschool_required,
            place:highschool_ans,
            start:e.target.value,
            end:highschool_end
        }
        setHighschool(temp);
    }

    const changeHighschool_end = (e) => {
        setHighschoolEnd(e.target.value);
        let temp ={
            required:highschool_required,
            place:highschool_ans,
            start:highschool_start,
            end:e.target.value
        }
        setHighschool(temp);
    }

    const changeHighschoolRequired = (e) => {
        setHighschoolRequired(e.target.checked);
        let temp ={
            required:e.target.checked,
            place:highschool_ans,
            start:highschool_start,
            end:highschool_end
        }
        setHighschool(temp);
    }

    const changeDiploma_ans = (e) => {
        setDiplomaAns(e.target.value);
        let temp ={
            required:diploma_required,
            place:e.target.value,
            start:diploma_start,
            end:diploma_end
        }
        setDiploma(temp);
    }

    const changeDiploma_start = (e) => {
        setDiplomaStart(e.target.value);
        let temp ={
            required:diploma_required,
            place:diploma_ans,
            start:e.target.value,
            end:diploma_end
        }
        setDiploma(temp);
    }

    const changeDiploma_end = (e) => {
        setDiplomaEnd(e.target.value);
        let temp ={
            required:diploma_required,
            place:diploma_ans,
            start:diploma_start,
            end:e.target.value
        }
        setDiploma(temp);
    }

    const changeDiplomaRequired = (e) => {
        setDiplomaRequired(e.target.checked);
        let temp ={
            required:e.target.checked,
            place:diploma_ans,
            start:diploma_start,
            end:diploma_end
        }
        setDiploma(temp);
    }

    const changeBachelor_ans = (e) => {
        setBachelorAns(e.target.value);
        let temp ={
            required:bachelor_required,
            place:e.target.value,
            start:bachelor_start,
            end:bachelor_end
        }
        setBachelor(temp);
    }

    const changeBachelor_start = (e) => {
        setBachelorStart(e.target.value);
        let temp ={
            required:bachelor_required,
            place:bachelor_ans,
            start:e.target.value,
            end:bachelor_end
        }
        setBachelor(temp);
    }

    const changeBachelor_end = (e) => {
        setBachelorEnd(e.target.value);
        let temp ={
            required:bachelor_required,
            place:bachelor_ans,
            start:bachelor_start,
            end:e.target.value
        }
        setBachelor(temp);
    }

    const changeBachelorRequired = (e) => {
        setBachelorRequired(e.target.checked);
        let temp ={
            required:e.target.checked,
            place:bachelor_ans,
            start:bachelor_start,
            end:bachelor_end
        }
        setBachelor(temp);
    }

    const changeMaster_ans = (e) => {
        setMasterAns(e.target.value);
        let temp ={
            required:master_required,
            place:e.target.value,
            start:master_start,
            end:master_end
        }
        setMaster(temp);
    }

    const changeMaster_start = (e) => {
        setMasterStart(e.target.value);
        let temp ={
            required:master_required,
            place:master_ans,
            start:e.target.value,
            end:master_end
        }
        setMaster(temp);
    }

    const changeMaster_end = (e) => {
        setMasterEnd(e.target.value);
        let temp ={
            required:master_required,
            place:master_ans,
            start:master_start,
            end:e.target.value
        }
        setMaster(temp);
    }

    const changeMasterRequired = (e) => {
        setMasterRequired(e.target.checked);
        let temp ={
            required:e.target.checked,
            place:master_ans,
            start:master_start,
            end:master_end
        }
        setMaster(temp);
    }
    
    return (
        <>
            <div className="container-fluid bg-white p-5 rounded justify-content-start" style={{width:"60%"}}>
                <div className="row d-flex">
                    <div className="col d-flex p-2">
                        <h6 style={{fontWeight:"bold"}}>Education</h6>
                    </div>
                </div>
                <div className="row d-flex">
                    <div className="col d-flex p-2">
                        <input type="checkbox" className="m-1" name="highschool" id="highschool" onClick={changeHighschoolRequired}/>
                        <label htmlFor="highschool" style={{fontWeight:"bold"}}>High School</label>
                    </div>
                </div>
                <div className="row d-flex">
                    <div className="row d-flex">
                        <div className="col-7 d-flex">
                            <input type="text" name="" id="highschool_ans" placeholder="Place" style={{width:"100%"}} onChange={changeHighschool_ans}/>
                        </div>
                        <div className="col-2 d-flex justify-content-center">
                            <input type="text" name="highschool_start" id="highschool_start" placeholder="Start" onChange={changeHighschool_start}/>
                        </div>
                        <div className="col-2 d-flex justify-content-start">
                            <input type="text" name="highschool_end" id="highschool_end" placeholder="End" onChange={changeHighschool_end}/>
                        </div>
                    </div>
                </div>
                <div className="row d-flex">
                    <div className="col d-flex p-2">
                        <input type="checkbox" className="m-1" name="diploma" id="diploma" onClick={changeDiplomaRequired}/>
                        <label htmlFor="diploma" style={{fontWeight:"bold"}}>Diploma Degree (D3)</label>
                    </div>
                </div>
                <div className="row d-flex">
                    <div className="row d-flex">
                        <div className="col-7 d-flex">
                            <input type="text" name="" id="highschool_ans" placeholder="Place" style={{width:"100%"}} onChange={changeDiploma_ans}/>
                        </div>
                        <div className="col-2 d-flex justify-content-center">
                            <input type="text" name="highschool_start" id="highschool_start" placeholder="Start" onChange={changeDiploma_start}/>
                        </div>
                        <div className="col-2 d-flex justify-content-start">
                            <input type="text" name="highschool_end" id="highschool_end" placeholder="End" onChange={changeDiploma_end}/>
                        </div>
                    </div>
                </div>
                <div className="row d-flex">
                    <div className="col d-flex p-2">
                        <input type="checkbox" className="m-1" name="bachelor" id="bachelor" onClick={changeBachelorRequired}/>
                        <label htmlFor="diploma" style={{fontWeight:"bold"}}>Bachelor Degree (S1)</label>
                    </div>
                </div>
                <div className="row d-flex">
                    <div className="row d-flex">
                        <div className="col-7 d-flex">
                            <input type="text" name="" id="highschool_ans" placeholder="Place" style={{width:"100%"}} onChange={changeBachelor_ans}/>
                        </div>
                        <div className="col-2 d-flex justify-content-center">
                            <input type="text" name="highschool_start" id="highschool_start" placeholder="Start" onChange={changeBachelor_start}/>
                        </div>
                        <div className="col-2 d-flex justify-content-start">
                            <input type="text" name="highschool_end" id="highschool_end" placeholder="End" onChange={changeBachelor_end}/>
                        </div>
                    </div>
                </div>
                <div className="row d-flex">
                    <div className="col d-flex p-2">
                        <input type="checkbox" className="m-1" name="master" id="master" onClick={changeMasterRequired}/>
                        <label htmlFor="diploma" style={{fontWeight:"bold"}}>Master Degree (D3)</label>
                    </div>
                </div>
                <div className="row d-flex">
                    <div className="row d-flex">
                        <div className="col-7 d-flex">
                            <input type="text" name="" id="highschool_ans" placeholder="Place" style={{width:"100%"}} onChange={changeMaster_ans}/>
                        </div>
                        <div className="col-2 d-flex justify-content-center">
                            <input type="text" name="highschool_start" id="highschool_start" placeholder="Start" onChange={changeMaster_start}/>
                        </div>
                        <div className="col-2 d-flex justify-content-start">
                            <input type="text" name="highschool_end" id="highschool_end" placeholder="End" onChange={changeMaster_end}/>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}