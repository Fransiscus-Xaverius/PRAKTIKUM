import { addToCart, inCart, removeFromCart } from "../app/cart";
import { useDispatch, useSelector } from "react-redux";
import { addToWishlist, removeFromWishlist, inWishlist, emptyWishlist } from '../app/wishlist';

export default function Catalogue(props) {
    console.log(props);
    const dispatch = useDispatch()
   

    return (
        <>
            <div className="card mb-3">
                <div className="row no-gutters">
                    <div className="col-md-4">
                        <img src={props.thumb} className="card-img" alt={`${props.title}'s thumbnail`} />
                    </div>
                    <div className="col-md-7">
                        <div className="card-body">
                            <h5 className="card-title">{props.title}</h5>
                            <p className="card-text">Normal Price: ${props.normalPrice}</p>
                            <p className="card-text">Metacritic Score: {props.metacriticScore}</p>
                            {props.salePrice && <p className="card-text">Sale Price: ${props.salePrice}</p>}
                            <p className="card-text">Release Date: {props.releaseDate}</p>
                            <button className="btn btn-success" onClick={
                                ()=>{
                                    try {
                                        dispatch(addToWishlist(props))
                                    } catch (error) {
                                        alert(error.message);
                                    }
                                }
                            }>Add to Wishlist</button>
                            <button className="btn btn-success" onClick={()=>{
                                try {
                                    const ihateprops = {
                                        gameID: props.gameID,
                                        title: props.title,
                                        normalPrice: props.normalPrice,
                                        salePrice: props.salePrice,
                                        metacriticScore: props.metacriticScore,
                                        releaseDate: props.releaseDate,
                                        thumb: props.thumb,
                                    }
                                    dispatch(addToCart(ihateprops))
                                } catch (error) {
                                    alert(error.message);
                                }
                            }}>Add to Cart</button>
                        </div>
                    </div>
                    <div className="col-md-1">
                        <h1>
                            {props.wishlist ? <h1>🧡</h1>: <h1>🖤</h1>}
                        </h1>
                    </div>
                </div>
            </div>
        </>
    );
}