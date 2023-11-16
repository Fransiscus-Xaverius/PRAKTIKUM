export default function Navbar({changePage}) {
    return(
        <>
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <a className="navbar-brand" href="#">Get Games</a>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
              <div className="navbar-nav">
                <a className="nav-item nav-link active" onClick={() => { changePage(0) }} href="#">Home</a>
                <a className="nav-item nav-link" onClick={() => { changePage(1) }} href="#">Catalogue</a>
                <a className="nav-item nav-link" onClick={() => { changePage(2) }} href="#">Wishlist</a>
                <a className="nav-item nav-link" onClick={() => { changePage(3) }} href="#">Cart</a>
                <a className="nav-item nav-link" onClick={() => { changePage(4) }} href="#">History</a>
              </div>
            </div>
          </nav>
        </>
    )
}