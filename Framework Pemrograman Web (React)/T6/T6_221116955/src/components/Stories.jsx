import React, { useEffect } from "react";
import { useLoaderData, useNavigate } from "react-router-dom";
import client from "../client";

export default function Stories() {
    const email = localStorage.getItem("email");
    const navigate = useNavigate();

    const stories = useLoaderData();

    const addStories = async () => {
        const url = "/stories?username=" + localStorage.getItem("username");
        try {
            const response = await client.post(url);
            console.log(response.data);
            if (response.status === 201) {
                alert("Berhasil menambahkan stories!");
                navigate("/stories/" + response.data.id +"/overview");
                return;
            }
        } catch (error) {
            alert(error);
        }
    };

    return (
        <>
            <div style={{ display: "flex", justifyContent: "center", alignItems: "center" }} onClick={()=>addStories()}>
                <div className="card" style={{width:"25rem", display: "flex", justifyContent: "center", alignItems: "center"}}>
                    <div className="card-body display-flex justify-content-center align-items-center text-center">
                        <h5 className="card-title">Add Stories</h5>
                        <h1>➕</h1>
                    </div>
                </div>
            </div>
            <div className="container-fluid d-flex justify-content-center align-items-center">
                {stories &&
                    stories.map((story, index) => {
                        console.log(story);
                        return (
                            <>
                                <div className="card m-3" style={{width:"25rem", display: "flex", justifyContent: "center", alignItems: "center"}} key={index} onClick={()=>navigate("/stories/" + story.id +"/overview")}>
                                    {story.poster && <img src={story.poster} className="card-img-top" alt="Story Image" />}
                                    <div className="card-body display-flex justify-content-center align-items-center text-center">
                                        <h5 className="card-title">{story.nama}</h5>
                                    </div>
                                </div>
                            </>
                        )
                    })
                }
            </div>
        </>
    );
}