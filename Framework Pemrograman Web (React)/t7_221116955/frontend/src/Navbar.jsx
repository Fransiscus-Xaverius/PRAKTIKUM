import { Outlet, useNavigate } from "react-router-dom"
import { NavLink, Link } from "react-router-dom"

export default function Navbar(){

    const navigate = useNavigate()

    return(
        <>
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <a className="navbar-brand" href="#">Futbol Menejer</a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav">
                        <li className="nav-item active">
                            <NavLink to="/" className="nav-link">Home</NavLink>
                        </li>
                        <li className="nav-item active">
                            <NavLink to="/players" className="nav-link">Players</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink to="/teams" className="nav-link">Teams</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink to="/matches" className="nav-link">Matches</NavLink>
                        </li>
                    </ul>
                </div>
            </nav>
            <div className="container-fluid">
                <Outlet />
            </div>
        </>
    )
}