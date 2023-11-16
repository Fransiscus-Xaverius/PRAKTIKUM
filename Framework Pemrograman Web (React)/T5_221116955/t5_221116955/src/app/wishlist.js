import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    wishlist:[]
}

export const wishlistSlice = createSlice({
    name: "wishlist",
    initialState,
    reducers: {
        addToWishlist: (state, action) => {
            console.log(action.payload);
            const index = state.wishlist.findIndex(
                (wishlistItem) => wishlistItem.gameID === action.payload.gameID
            );
            if(index>-1){
                throw new Error("Item already added in wishlist");
            }
            alert(`${action.payload.title} added to wishlist`)
            state.wishlist.push(action.payload);
            console.log(state.wishlist);
        },
        removeFromWishlist: (state, action) => {
            const index = state.wishlist.findIndex(
                (wishlistItem) => wishlistItem.gameID === action.payload
            );
            if(index>-1){
                state.wishlist.splice(index,1);
            }
        },
        inWishlist: (state, action) => {
            const index = state.wishlist.findIndex(
                (wishlistItem) => wishlistItem.id === action.payload
            );
            if(index>-1){
                return true;
            }
            return false;
        },
        emptyWishlist: (state) => {
            state.wishlist = [];
        }
    }
});

export const { addToWishlist, removeFromWishlist, inWishlist, emptyWishlist } = wishlistSlice.actions;

export default wishlistSlice.reducer;