import { useState, useEffect } from "react";
import client from "../client";
export default function DataSection({type}){
    const [data, setData] = useState(null)
    let url = ""
    if(type === "deals"){
        url = "/deals?storeID=1&pageSize=5"
    } else if(type === "top"){
        url = "/deals?storeID=1&sortBy=Metacritic&desc=1&pageSize=5"
    } else if(type === "new"){
        url = "/deals?storeID=1&sortBy=Release&desc=1&pageSize=5"
    }
    
    useEffect(() => {
        client.get(url)
        .then((response) => {
            setData(response.data)
        })
        .catch((error) => {
            console.log(error)
        })
    }, [])

    return (
        <>
            <div className="container-fluid rounded">
                {!data && <div>Loading...</div>}
                {data?.map(({ dealID, thumb, title, normalPrice, salePrice, savings }) => (
                    <div key = {dealID} className="card mt-3" style={{minWidth:"450px", maxWidth:"450px", minHeight:"400px"}} >
                        <img className="card-img-top" src={thumb} alt="Card image cap"></img>
                        <div className="card-body">
                            <h5 className="card-title">{title}</h5>
                            <p className="card-text">Normal Price:{normalPrice}</p>
                            <p className="card-text">Sale Price: {salePrice}</p>
                            <a href="#" className="btn btn-primary">Wishlist</a>
                        </div>
                    </div>
                ))}
            </div>
        </>
    )
}