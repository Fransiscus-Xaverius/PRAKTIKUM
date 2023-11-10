export default function ExpItem({item}){
    return (
        <>
            <div className="container-fluid">
                <div className="row">
                    <div className="col-5">
                        <h6>{item.title}</h6>
                    </div>
                    <div className="col-5">
                        <h6>{item.place}</h6>
                    </div>
                </div>
                <div className="row">
                    <div className="col-7">
                        <p>{item.description}</p>
                    </div>
                    <div className="col-2">
                        <p>{item.start}</p>
                    </div>
                    <div className="col-2">
                        <p>{item.end}</p>
                    </div>
                </div>
            </div>
        </>
    )
}