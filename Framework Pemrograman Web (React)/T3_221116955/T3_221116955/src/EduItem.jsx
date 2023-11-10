export default function EduItem({tingkat, name, start, end}){
    console.log(name);
    return (
        <>
            <hr ></hr>
            <div className="container">
                <div className="col">
                    <div className="row d-flex">
                        <h6 style={{fontWeight:"bold"}}>{tingkat}</h6>
                        <br />
                        <h6>{name}</h6>
                    </div>
                </div>
                <div className="col">
                    <h6>{start}-{end}</h6>
                </div>
            </div>
            <hr />
        </>
    )
}