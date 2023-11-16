import { useState, useEffect } from "react";
import client from "../client";
import { useDispatch } from "react-redux";
import { addToCart, inCart, removeFromCart } from "../app/cart";
import { addToWishlist, removeFromWishlist, inWishlist, emptyWishlist } from '../app/wishlist';


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

    const dispatch = useDispatch()
    const actionAddCart = data => {
        
    }

    return (
        <>
            <div className="container-fluid rounded">
                {!data && <div>Loading...</div>}
                {data?.map((data) => (
                    <div key = {data.dealID} className="card mt-3" style={{minWidth:"450px", maxWidth:"450px", minHeight:"400px"}} >
                        <img className="card-img-top" src={data.thumb} alt="Card image cap"></img>
                        <div className="card-body">
                            <h5 className="card-title">{data.title}</h5>
                            <p className="card-text">Normal Price:{data.normalPrice}</p>
                            <p className="card-text">Sale Price: {data.salePrice}</p>
                            <button className="btn btn-primary" onClick={()=>{
                                try {
                                    dispatch(addToWishlist(data))
                                } catch (error) {
                                    alert(error.message);
                                }
                            }}>Wishlist</button>
                            <button className="btn btn-success" onClick={()=>{
                                try {
                                    dispatch(addToCart(data))
                                } catch (error) {
                                    alert(error.message);
                                }
                            }}>Add to Cart</button>
                        </div>
                    </div>
                ))}
            </div>
        </>
    )
}