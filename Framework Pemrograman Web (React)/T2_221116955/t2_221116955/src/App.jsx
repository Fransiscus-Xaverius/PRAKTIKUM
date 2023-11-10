import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import PlanDetail from './PlanDetail'
import PlanList from './PlanList'
import PlanItem from './PlanItem'
import AddPlan from './AddPlan'

function App() {
  const [count, setCount] = useState(0)
  const [choosenPlan, setChoosen] = useState(-1);
  const [plan, setPlan] = useState([
    {
      name: "Chest Shoulder Tricep Dumbbell",
      difficulty: "beginner",
      durationMin: 10,
      durationMax: 15,
      gender: "intersex",
      menu:[
        {
          set: 1,
          name: "Fast-Paced Walk",
          reps: 3,
          repType: "mins"
        }
      ]
    },
    {
      name: "Chest Shoulder Tricep Dumbbell",
      difficulty: "intermediate",
      durationMin: 10,
      durationMax: 15,
      gender: "male",
      menu:[
        {
          set: 1,
          name: "Fast-Paced Walk",
          reps: 3,
          repType: "mins"
        }
      ]
    },
    {
      name: "Lari sampe mampus",
      difficulty: "Hard",
      durationMin: 100,
      durationMax: 300,
      gender: "intersex",
      menu:[
        {
          set: 1,
          name: "Marathon",
          reps: 300,
          repType: "mins"
        }
      ]
    }
  ]) 
  const [mode, setMode] = useState(1);
  let data = {
    choosenPlan: true
  };

  const savePlan = (newPlan) => {
    setPlan([...plan, newPlan]);
  }

  const setModeAdd = () => {
    setChoosen(-2);
    setMode(1);
  }

  const setModeDetail = (index) =>{
    setChoosen(index);
    setMode(1);
  }

  const setModeUpdate = (index) => {
    setChoosen(index);
    setMode(0);
  }

  const removePlan = (index) => {
    let temp = plan;
    temp.splice(index, 1);
    setPlan([...temp]);
    setChoosen(-1);
  }

  return (
    <>
      <div className="container-fluid bg-transparent text-center">
        <div className="row">
          <h2 className='text-white p-3'>GetFit</h2>
        </div>
        <div className="row">
          <div className="container-fluid col-5 m-4 p-0 justify-content-end">
            <div className="row d-flex justify-content-end">
              <PlanList data={plan} onclick={setModeDetail}></PlanList>
            </div>
            <div className="row d-flex justify-content-end m-5">
              <button className="btn btn-primary" style={{width:"200px"}} onClick={setModeAdd}>+ Add new Plan</button>
            </div>
          </div>
          <div className="col-6 m-4">
            <PlanDetail curdata={choosenPlan} mode={mode} data={plan} addPlanFunction={savePlan} removePlan={removePlan} updatePlan={setModeUpdate}></PlanDetail>
          </div>
        </div>
      </div>
    </>
  )
}

export default App
