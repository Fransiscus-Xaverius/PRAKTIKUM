import DetailChild from "./DetailChild";
import berangkat from "../assets/berangkat.png";
import sampai from "../assets/sampai.png";
import tanggal from "../assets/tanggal.png";
import durasi from "../assets/durasi.png";

export default function Detail({data}){
    let randomFlight = data[Math.floor(Math.random()*data.length)];
    let jenis = randomFlight.jenis;
    return (
        <>
            <div className="rounded bg-light p-3" style={{width:"600px", height:"500px"}}>
                <h3>{randomFlight.pesawat.maskapai} - {randomFlight.pesawat.model}</h3>
                <DetailChild key='1' {...randomFlight}></DetailChild>
                <div className="container">
                    <div className="row m-1">
                        <div className="col-5">
                            <p style={{fontWeight:"bold"}}>
                                Boarding Date <br />
                                Boarding Time <br />
                                Duration <br />
                                Flight Type <br />
                            </p>
                        </div>
                        <div className="col-5">
                            <p style={{fontWeight:"bold"}}>
                                {randomFlight.jadwal.berangkat.tanggal} <br />
                                {randomFlight.jadwal.berangkat.jam} <br />
                                {randomFlight.jadwal.durasi} <br />
                                {jenis}
                            </p>
                        </div>
                    </div>
                </div>
                <div className="container">
                    <div className="row justify-content-center m-auto">
                        <div className="col-5">
                            <h4>Departure</h4>
                            <div className="row">
                                <div className="col-2 m-2">
                                    <img src={berangkat} alt="" style={{width:"50px", height:"50px"}}/>
                                </div>
                                <div className="col container-fluid">
                                    <img src={tanggal} alt="" style={{width:"30px", height:"30px"}}/>
                                    {randomFlight.jadwal.berangkat.tanggal}
                                    <br />
                                    <img src={durasi} alt="" style={{width:"30px", height:"30px"}}/>
                                    {randomFlight.jadwal.berangkat.jam}
                                </div>
                            </div>
                        </div>
                        <div className="col-5">
                            <h4>Arrival</h4>
                            <div className="row">
                                <div className="col-2 m-2">
                                    <img src={sampai} alt="" style={{width:"50px", height:"50px"}}/>
                                </div>
                                <div className="col container-fluid">
                                    <img src={tanggal} alt="" style={{width:"30px", height:"30px"}}/>
                                    {randomFlight.jadwal.sampai.tanggal}
                                    <br />
                                    <img src={durasi} alt="" style={{width:"30px", height:"30px"}}/>
                                    {randomFlight.jadwal.sampai.jam}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}