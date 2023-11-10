import MenuItem from "./MenuItem"
import { useState } from "react"

export default function UpdatePlan(data){

    console.log("update");
    let plandata = (data.plan[data.curdata]);

    const [newPlan, setNewPlan] = useState(plandata)


    const handleNameChange = (event) => {
        newPlan.name = event.target.value;  
        setNewPlan({...newPlan});
    }

    const handleDifficultyChange = (event) => {
        newPlan.difficulty = event.target.value;
        setNewPlan({...newPlan});
    }

    const handleDurationMinChange = (event) => {
        newPlan.durationMin = event.target.value;
        setNewPlan({...newPlan});
    }

    const handleDurationMaxChange = (event) => {
        newPlan.durationMax = event.target.value;
        setNewPlan({...newPlan});
    }

    const handleGenderChange = (event) => {
        newPlan.gender = event.target.value;
        setNewPlan({...newPlan});
    }

    const [menu, setMenu] = useState(plandata.menu)

    console.log('menu');
    console.log(menu);

    const addMenu = () => {
        const newMenu ={
            set: -1,
            name: "",
            reps: -1,
            repType: ""
        }
        setMenu([...menu, newMenu])
    }

    const changeMenu = (index, set, name, reps, repType) => {
        if(set){
            menu[index].set = set;
        }
        if(name){
            menu[index].name = name;
        }
        if(reps){
            menu[index].reps = reps;
        }
        if(repType){
            menu[index].repType = repType;
        }
        setMenu([...menu]);
        refreshMenu();
    }

    const refreshMenu = () => {
        newPlan.menu = menu;
        setNewPlan({...newPlan});
    }

    const save = () => {
        addPlanFunction(newPlan)
    }

    const removeMove = (index) => {
        menu.splice(index, 1);
        setMenu([...menu]);
        refreshMenu();
    }

    return (
        <>
            <div className="container-fluid">
                <div className="row m-2">
                    <div className="col-8 m-8">
                        <input type="text" value={newPlan.name} name="plan-name" id="" style={{width:"400px", height:"35px"}}onChange={handleNameChange}/ >
                    </div>
                    <div className="col">
                        <div className="btn btn-primary text-white" style={{width:"170px", height:"35px"}} onClick={save}>Save</div>
                    </div>
                </div>
                <div className="row m-2">
                    <div className="col-2 d-flex">
                        <p className="m-2 pt-1">Difficulty: </p>   
                        <select name="diff" selected={newPlan.difficulty} className="m-2 p-1" id="" style={{height:"35px"}} onChange={handleDifficultyChange}>
                            <option value="beginner">Beginner</option>
                            <option value="intermediate">Intermediate</option>
                            <option value="hard">Hard</option>
                        </select>
                    </div>
                </div>
                <div className="row m-2">
                    <div className="col-10 d-flex">
                        <p className="m-2">Duration Range: </p>   
                        <input className="m-2" type="text" name="durationMin" value={newPlan.durationMin} placeholder="10" id="" style={{height:"25px", width:"40px"}} onChange={handleDurationMinChange}/>
                        <p className="m-2"> to </p>
                        <input className="m-2" type="text" name="durationMax" value={newPlan.durationMax} placeholder="15" id="" style={{height:"25px", width:"40px"}} onChange={handleDurationMaxChange}/>
                        <p className="m-2"> minutes </p>
                    </div>
                </div>
                <div className="row m-2">
                    <div className="col-2 d-flex">
                        <p className="m-2 pt-1">Gender: </p>   
                        <select name="diff" className="m-2 p-1" id="" style={{height:"35px"}} onChange={handleGenderChange}>
                            <option value="female">Female</option>
                            <option value="male">Male</option>
                            <option value="intersex">Intersex</option>
                        </select>
                    </div>
                </div>
                <div className="row m-2">
                    <div className="col-8 m-8">
                        <p className="fw-semibold text-start">Menu:</p>
                    </div>
                    <div className="col">
                        <div className="btn btn-primary text-white" style={{width:"170px", height:"35px"}} onClick={addMenu}>Add Menu</div>
                    </div>
                </div>
                <div className="row m-2" style={{overflowY:"auto", maxHeight:"300px"}}>
                    {
                        menu.map((item, index) => {
                            return (
                                <MenuItem key={index} index={index} menu={menu} onchange={changeMenu} removeMenu={removeMove}></MenuItem>
                            )
                        })  
                    }
                </div>
            </div>
        </>
    )
}