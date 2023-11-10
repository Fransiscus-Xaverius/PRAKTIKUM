export default function Catalogue(props) {
    console.log(props);
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
                            {props.wishlist ? <button className="btn btn-success" onClick={()=>{props.removeFromWishlist(props.gameID)}}>Remove from Wishlist</button>:<button className="btn btn-success" onClick={()=>{props.addToWishlist(props.gameID, props)}}>Add to Wishlist</button>}
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