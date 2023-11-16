import {configureStore} from "@reduxjs/toolkit"
import cartReducer from "./cart"
import wishlistReducer from "./wishlist"
import historyReducer from "./history"
//store digunakan untuk menampung semua slice redux
const store = configureStore({
    reducer:{
        cart: cartReducer,
        wishlist: wishlistReducer,
        history: historyReducer,
    },
})
export default store;