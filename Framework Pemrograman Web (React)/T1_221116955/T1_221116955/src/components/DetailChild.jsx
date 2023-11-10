export default function DetailChild(randomFlight){
    let flagImg = `https://flagcdn.com/w80/${randomFlight.asal.flag}.png`
    let flagImg2 = `https://flagcdn.com/w80/${randomFlight.tujuan.flag}.png`
    console.log(randomFlight);
    return (
        <>
            <div className="container-fluid rounded bg-info m-auto">
                    <div className="row">
                        <div className="col-sm-4 align-middle">
                            <div className="m-3">
                                <img src={flagImg} alt="" />  
                                <br />
                                <b>{randomFlight.asal.bandara}</b>
                            </div>
                        </div>
                        <div className="col-sm">
                            <div className="m-3">
                                <h1>➡</h1>
                            </div>
                        </div>
                        <div className="col-sm-4 align-middle">
                            <div className="m-3">
                            <img src={flagImg} alt=""  />
                            <br />
                            <b>{randomFlight.tujuan.bandara}</b>
                       </div>
                    </div>
                </div>
            </div>
        </>
    )
}