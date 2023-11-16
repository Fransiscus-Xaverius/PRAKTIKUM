import Navbar from "./Navbar"
import { useState, useEffect } from 'react'
import client from "../client"
import {useSelector ,useDispatch } from "react-redux"
import CartItem from "./CartItem"
import { addToWishlist, removeFromWishlist, inWishlist, emptyWishlist } from '../app/wishlist';
import { addToHistory } from "../app/history"
import { emptyCart } from "../app/cart"

export default function Cart({changePage}){
    const dispatch = useDispatch()  
    const cart = useSelector((state)=> state.cart.cart);
    console.log(cart.length === 0);
    let total_price = 0;

    const checkout = () =>{

    }

    return (
        <>
        <div className="">
            <Navbar changePage={changePage}></Navbar>
            <div className="container-fluid">
                {cart?.length === 0 && <div><h1>Tidak ada games di cart</h1></div>}
                {cart.map((item, index) => {
                    total_price += parseFloat(item.salePrice);
                    return (
                        <CartItem key={index} gameID={item.gameID} title={item.title} normalPrice={item.normalPrice} salePrice={item.salePrice} metacriticScore={item.metacriticScore} releaseDate={item.releaseDate} thumb={item.thumb} addToWishlist={addToWishlist} removeFromWishlist={removeFromWishlist}></CartItem>
                    )
                })}
                <hr />
                <div className="row">
                    <div className="container-fluid">
                        <h1>Total Price: ${total_price}</h1>
                        <button className="btn btn-success" onClick={()=>{
                            try {
                                const ihatethis = {
                                    cart: cart,
                                    total_price: total_price,
                                    time: new Date().toLocaleString()
                                }
                                alert("Thank you for your purchase")
                                dispatch(addToHistory(ihatethis))
                                dispatch(emptyCart())
                            } catch (error) {
                                alert(error.message);
                            }
                        }}>Order</button>
                    </div>
                </div>
            </div>
        </div>
        </>
    )
}