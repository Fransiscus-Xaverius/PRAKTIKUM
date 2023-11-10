export default function Item(props) {
    const inter = props.jenis.match("internasional");
    if(inter){
        return (
            <>
                <div className="container-fluid bg-light rounded mt-1 p-1" style={{ width: "450px", height: "100px" }}>
                    <div className="row">
                        <div className="col-8">
                            <b className="m-0 p-0">{props.asal.alias} - {props.tujuan.alias}</b>
                            <br />
                            {props.jadwal.berangkat.tanggal}
                            <br />
                            <p>{props.pesawat.maskapai} - {props.pesawat.model}</p>
                        </div>
                        <div className="col-2 flex-fill p-3">
                            <div className="container-fluid text-light rounded bg-success" >
                                Internasional
                            </div>
                            <b>Departs on {props.jadwal.sampai.jam}</b>
                        </div>
                    </div>
                </div>
            </>
        )
    }
    else{
        return (
            <>
                <div className="container-fluid bg-light rounded mt-1 p-1" style={{ width: "450px", height: "100px" }}>
                    <div className="row">
                        <div className="col-8">
                            <b className="m-0 p-0">{props.asal.alias} - {props.tujuan.alias}</b>
                            <br />
                            {props.jadwal.berangkat.tanggal}
                            <br />
                            <p>{props.pesawat.maskapai} - {props.pesawat.model}</p>
                        </div>
                        <div className="col-2 flex-fill p-3">
                            <div className="container-fluid text-light rounded bg-primary" >
                                Domestik
                            </div>
                            <b>Departs on {props.jadwal.sampai.jam}</b>
                        </div>
                    </div>
                </div>
            </>
        )
    }
}
