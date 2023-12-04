import React from 'react';
import { Outlet } from 'react-router-dom';
import {NavLink, useNavigate} from 'react-router-dom';

export default function Navbar() {

    const navigate = useNavigate();

    const logOut = () =>{
        localStorage.clear();
        navigate('/login');
    }

    const username = localStorage.getItem("nama");
    return (
        <>
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <a className="navbar-brand" href="#">Kisahku</a>
        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav">
            {username && 
                <>
                    <li className="nav-item active">
                        <NavLink className="nav-link" to="/stories">Story</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink className="nav-link" to="/profile">Profile</NavLink>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="#" onClick={logOut}>Logout</a>
                    </li>
                </>
            }
            {!username &&
                <>
                    <li className="nav-item active">
                        <NavLink className="nav-link" to="/login">Login</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink className="nav-link" to="/register">Register</NavLink>
                    </li>
                </>
            }
          </ul>
            {
                username &&  <p>Hi, {username}</p>
            }
        </div>
      </nav>
            <Outlet />
        </>
    );
}
