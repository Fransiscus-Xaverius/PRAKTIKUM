import Navbar from "./Navbar"
import { useState, useEffect } from 'react'
import client from "../client"
import {useSelector ,useDispatch } from "react-redux"
import CartItem from "./CartItem"
import { addToWishlist, removeFromWishlist, inWishlist, emptyWishlist } from '../app/wishlist';

export default function History({changePage}){

    const dispatch = useDispatch()
    const history = useSelector((state)=> state.history.history);

    return (
        <>
        <div className="">
            <Navbar changePage={changePage}></Navbar>
                {history.map((item, index) => {
                    return (
                        <>
                        <div className="card" key={index}>
                            <div className="card-body">
                                <h5>{item.time}</h5>
                                <h5>Items:</h5>
                                {item.cart.map((itm, index) => {
                                    return(
                                       <>
                                        <h6>{itm.title}</h6>
                                        <img src={itm.thumb}></img>
                                       </>
                                    )
                                })}
                                <br />
                                <p className="card-text">Total Price: ${item.total_price}</p>
                            </div>
                        </div>
                        </>
                    )
                })}
        </div>
        </>
    )
}
    