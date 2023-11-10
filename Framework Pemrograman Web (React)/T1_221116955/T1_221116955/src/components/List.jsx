import Item from './ListItem';
export default function List({data}){
    return (
        <div className="container-fluid rounded bg-primary" style={{width:"600px", height:"500px"}}>
            <h3 className="p-1">List Penerbangan</h3>
            <div className="container-fluid centered">
                <div className="container-fluid scroll">
                    {
                        data.map((x,index)=>{
                            // console.log(x.asal.alias);
                            return(
                                <Item key={index} {...x}></Item>
                            )
                        })
                    }
                </div>
            </div>
        </div>
    )
}