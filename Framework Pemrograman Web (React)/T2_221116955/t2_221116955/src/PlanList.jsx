import PlanItem from "./PlanItem"

export default function PlanList({data, onclick}){
    
    console.log(data)
    return (
        
        <div className="rounded bg-white p-3" style={{ width: '65%', height: '60vh' }}>
            {
                data.map((x,index)=>{
                    
                    return(
                        <PlanItem key={index} {...x} index={index} onclick={()=>{onclick(index)}}></PlanItem>
                    )
                })
            }
        </div>
    )
}