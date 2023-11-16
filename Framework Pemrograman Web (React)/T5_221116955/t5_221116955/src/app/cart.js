import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    cart:[]
}

export const cartSlice = createSlice({
    name: "cart",
    initialState,
    reducers: {
        addToCart: (state, action) => {
            const index = state.cart.findIndex(
                (cartItem) => cartItem.gameID === action.payload.gameID
            );
            if(index>-1){
                throw new Error("Item already added in cart");
                
            }
            alert(`${action.payload.title} added to cart`)
            state.cart.push(action.payload);
            console.log(state.cart);
        },
        removeFromCart: (state, action) => {
            const index = state.cart.findIndex(
                (cartItem) => cartItem.gameID === action.payload
            );
            if(index>-1){
                state.cart.splice(index,1);
            }
        },
        inCart: (state, action) => {
            const index = state.cart.findIndex(
                (cartItem) => cartItem.id === action.payload.id
            );
            if(index>-1){
                return true;
            }
            return false;
        },
        emptyCart: (state) => {
            state.cart = [];
        }
    }
});

export const { addToCart, removeFromCart, inCart, emptyCart } = cartSlice.actions;

export default cartSlice.reducer;
