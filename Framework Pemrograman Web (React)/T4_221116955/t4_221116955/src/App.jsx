import { useState, useEffect } from 'react';
import './App.css';
import DataSection from './components/DataSection';
import Catalogue from './components/Catalogue';
import Navbar from './components/Navbar';
import client from "./client";

function App() {

  const [count, setCount] = useState(0);
  const [page, setPage] = useState(0);
  const [catalogue, setCatalogue] = useState(null);
  const [searchkey, setSearchkey] = useState("");
  const [keyword, setKeyword] = useState("");
  const [wishlist, setWishlist] = useState([]);
  const [details, setDetails] = useState([]);

  const changePage = (index)=>{
    setPage(index);
  }

  const addToWishlist = (e, gamedata) =>{
    setWishlist([...wishlist, e]);
    setDetails([...details, gamedata]);
  }

  const isInWishlist = (id) =>{
    return wishlist.includes(id);
  }

  const removeFromWishlist = (id) =>{
    setWishlist(wishlist.filter(item => item !== id));
    setDetails(details.filter(item => item.gameID !== id));
  }

  const changesearchkey = (e) => {
    setSearchkey(e.target.value);
  }

  const prev = (e) =>{
    if(count>0) setCount(count-1);
  }

  const next = (e) =>{
    setCount(count+1);
  }

  const searchNow = () =>{
    setKeyword(searchkey)
    setCount(0)
  }



  useEffect(() => {
    let url = "/deals?title=" + keyword + "&pageSize=10&pageNumber="+count+"&storeID=1";
    client.get(url)
    .then((response) => {
        console.log(response.data)
        setCatalogue(response.data)
    })
    .catch((error) => {
        console.log(error)
    })
  }, [keyword])

  useEffect(() => {
    let url = "/deals?title=" + keyword + "&pageSize=10&pageNumber="+count+"&storeID=1";
    client.get(url)
    .then((response) => {
        console.log(response.data)
        setCatalogue(response.data)
    })
    .catch((error) => {
        console.log(error)
    })
  }, [count])

  useEffect(() => {
    let url = "/deals?title=" + keyword + "&pageSize=10&pageNumber="+count+"&storeID=1";
    client.get(url)
    .then((response) => {
        console.log(response.data)
        setCatalogue(response.data)
    })
    .catch((error) => {
        console.log(error)
    })
  }, [wishlist])

  if (page === 0) {
    return (
      <>
        <div>
          <Navbar changePage={changePage}/>
          <div className="container-fluid">
            <div className="row container-fluid justify-content-center p-5">
              <div className="col-4 d-flex justify-content-center">
                <div className="card">
                  <div className="card-body">
                    <h5 className="card-title">Best Deals</h5>
                    <DataSection type="deals" />
                  </div>
                </div>
              </div>
              <div className="col-4 d-flex justify-content-center">
                <div className="card">
                  <div className="card-body">
                    <h5 className="card-title">Newest</h5>
                    <DataSection type="new" />
                  </div>
                </div>
              </div>
              <div className="col-4 d-flex justify-content-center">
                <div className="card">
                  <div className="card-body">
                    <h5 className="card-title">Best Metacritic</h5>
                    <DataSection type="top" />
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </>
    )
  } else if (page === 1) {
    return (
      <>
        <div>
          <Navbar changePage={changePage}/>
        </div>
        <div className="container-fluid">
            <div className="row">
              <div className="align-items-center p-3">
                <div className="input-group mb-3">
                  <input type="text" id="searchgamebar" className="form-control" placeholder="Search Games" onChange={changesearchkey}></input>
                  <div className="input-group-append">
                    <button className="btn btn-danger text-white" type="button" onClick={searchNow}>Search</button>
                  </div>
                </div>
              </div>
            </div>
            <div className="row p-3">
              <div className="row">
                {!catalogue && <div>Loading...</div>}
                {catalogue?.length === 0 && <div><h1>Tidak ada data</h1></div>}
                {catalogue.map((item, index) => (
                  <Catalogue key={index} {...item} wishlist={isInWishlist(item.gameID)} addToWishlist={addToWishlist} removeFromWishlist={removeFromWishlist}/>
                ))}
              </div>
              <div className="col d-flex justify-content-end">
                <span className='m-3'>Current Page: {count+1}</span>
                <button className="btn btn-primary m-1" style={{minWidth:"100px"}} onClick={prev}>Previous</button>
                <button className="btn btn-primary m-1" style={{minWidth:"100px"}} onClick={next}>Next</button>
              </div>
            </div>
        </div>
      </>
    )
  } else if (page === 2) {
    return (
      <>
        <div>
          <Navbar changePage={changePage}/>
          <div className="container-fluid">
            {wishlist?.length === 0 && <div><h1>Tidak ada games di wishlist</h1></div>}
            {details.map((item, index) => (
              <Catalogue key={index} {...item} wishlist={isInWishlist(item.gameID)} addToWishlist={addToWishlist} removeFromWishlist={removeFromWishlist}/>
            ))}
          </div>
        </div>
      </>
    )
  }
}

export default App;
