import React, { useState } from 'react';
import './App.css';
import Header from './components/header';
import MainContent from './components/mainContent';
import Footer from './components/footer';
import {BrowserRouter as Router,Route,Switch} from 'react-router-dom';
import Cart from "./components/cart";
import Orders from "./components/orders";
import Profile from "./components/profile";
import Catalog from './components/catalog';
import Signup from './components/Signup';
import Login from './components/Login';
import ProductCatalog from './components/ProductCatalog';

function App() {
  const [hidehead,setHide]=useState(window.location.pathname==="/login"?true:false);
  const [hidehea]=useState(window.location.pathname==="/signup"?true:false);
  
 
  const seHead=()=>{
    setHide(window.location.pathname==="/login"?true:false);

  }
  return (
    <Router>
      
      <Route path="/login"><Login set={seHead}/></Route>
      <Route path="/signup"><Signup /></Route>
      
    <div className="container">
      <Header hidden={hidehead} hidden1={hidehea}/>
       <Switch>
            <Route exact path="/"><MainContent/></Route>
            <Route path="/cart"><Cart /></Route>
            <Route path="/orders"><Orders /></Route>
            <Route path="/profile"><Profile /></Route>
            <Route path="/catalog"><Catalog /></Route>
            <Route path="/ProductCatalog/:productId" component={ProductCatalog}/>
            {/* <Route path="/ProductCatalog/*"><ProductCatalog /></Route> */}
            <Route path="/logout"><Login /></Route>  
        </Switch>
    <Footer hidden={hidehead} hidden1={hidehea} />
    </div>
    </Router>
  );
}

export default App;



