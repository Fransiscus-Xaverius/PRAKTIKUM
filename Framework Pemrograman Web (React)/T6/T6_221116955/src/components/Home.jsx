import { NavLink } from "react-router-dom";

export default function Home(){
    
    const email = localStorage.getItem("email");

    return (
        <>
            <div className="container-fluid display-flex justify-content-center align-items-center">
                <h1>Welcome to Kisahku</h1>

                <p>Stories is a place where you can share your stories.</p>

                {!email && <>
                    <p> <NavLink to="/register">Register</NavLink> or <NavLink to="/login">Login</NavLink> to share your stories.</p>
                </>}

                {email && <>
                    <p>Choose a menu!</p>
                </>}
            </div>

        </>
    )
}