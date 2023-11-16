import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    history:[]
}

export const historySlice = createSlice({
    name: "history",
    initialState,
    reducers: {
        addToHistory: (state, action) => {
            state.history.push(action.payload);
            console.log(state.history);
        }
    }
});

export const { addToHistory } = historySlice.actions;

export default historySlice.reducer;