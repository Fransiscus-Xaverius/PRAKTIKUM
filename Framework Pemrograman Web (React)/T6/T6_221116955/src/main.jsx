import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import { createBrowserRouter, Router, RouterProvider } from 'react-router-dom'
import Navbar from './components/Navbar';
import Login from './components/Login';
import Register from './components/Register';
import Stories from './components/Stories';
import Home from './components/Home';
import Profile from './components/Profile';
import Overview from './components/Overview';

import DataHandler from './DataHandler';

const {loadStories} = DataHandler;

const router = createBrowserRouter([
  {
    path: '/',
    element: <Navbar />,
    children:[
      {
        index: true,
        element: <Home />
      },
      {
        path: '/login',
        element: <Login />,
      },
      {
        path: '/register',
        element: <Register />,
      },
      {
        path: '/stories',
        element: <Stories />,
        loader:loadStories
      },
      {
        path: 'stories/:story_id/overview',
        element: <Overview />,
        loader:loadStories
      },
      {
        path: '/profile',
        element: <Profile />
      }
    ]
  }
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <RouterProvider router={router}/>
)
