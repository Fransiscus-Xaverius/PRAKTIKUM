import AddPlan from './AddPlan';
import SeeDetail from './SeeDetail';
import UpdatePlan from './UpdatePlan';
export default function PlanDetail(data){
    console.log(data.addPlanFunction)
    let content;
    // console.log(data.curdata);
    if(data.curdata==-1){
        content = "Choose a plan to see detail here";
        return (
            <div className="rounded bg-white p-5 d-flex justify-content-center align-items-center" style={{ width: '85%', height: '75vh' }}>
                <div className="d-flex justify-content-center align-items-center">
                    <h1 className="text-center text-muted">{content}</h1>
                </div>
            </div>
        )
    }
    else if(data.curdata==-2){
        return (
            <div className="rounded bg-white p-5 d-flex justify-content-center align-top" style={{ width: '85%', height: '75vh' }}>
                <div className="d-flex justify-content-center align-items-center align-top">
                    <AddPlan addPlanFunction={data.addPlanFunction}></AddPlan>
                </div>
            </div>
        )
    }
    else{
        if(data.mode==1){
            return (
                <div className="rounded bg-white p-5 d-flex justify-content-center align-top" style={{ width: '85%', height: '75vh' }}>
                    <div className="d-flex justify-content-center align-items-center align-top">
                        <SeeDetail data={data.data} curdata={data.curdata} removePlan={data.removePlan} updatePlan={data.updatePlan}></SeeDetail>
                    </div>
                </div>
            )
        }
        else{
            return (
                <div className="rounded bg-white p-5 d-flex justify-content-center align-top" style={{ width: '85%', height: '75vh' }}>
                    <div className="d-flex justify-content-center align-items-center align-top">
                        <UpdatePlan plan={data.data} curdata={data.curdata}></UpdatePlan>
                    </div>
                </div>
            )
        }
    }
    
}