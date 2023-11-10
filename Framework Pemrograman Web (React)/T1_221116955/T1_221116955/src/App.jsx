import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import List from './components/List'
import data from './data.json';
import Detail from './components/Details';

function App() {
  return (
    <>
     <div>
        <div className="container-fluid centered">
          <div className="row">
            <div className="col-6">
              <List data={data}></List>
            </div>
            <div className="col-4">
              <Detail data={data}></Detail>
            </div>
          </div>
        </div>
      </div>
    </>
  )
}

export default App
