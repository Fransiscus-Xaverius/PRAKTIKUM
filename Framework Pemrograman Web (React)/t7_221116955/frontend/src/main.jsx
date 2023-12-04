import React from 'react'
import ReactDOM from 'react-dom/client'
import Navbar from './Navbar.jsx'
import Home from './Home.jsx'
import Teams from './Teams.jsx'
import { createBrowserRouter, Router, RouterProvider } from 'react-router-dom'
import DataHandler from './DataHandler.jsx'
import Players from './Players.jsx'

const {getAllTeams,getAllData, getAllPlayers, getHomeData} = DataHandler;

const router = createBrowserRouter([
  { 
    path: '/', 
    element: <Navbar />,
    children:[
      {
        index: true,
        loader: getHomeData,
        element: <Home />
      },
      {
        path: '/players',
        loader: getAllData,
        element: <Players />
      },
      {
        path: '/teams',
        loader: getAllTeams,
        element: <Teams />,
      }
    ]
  },
])

ReactDOM.createRoot(document.getElementById('root')).render(
  <RouterProvider router={router} />
)
