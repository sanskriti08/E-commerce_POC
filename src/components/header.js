import React from 'react';
import { Button } from '@material-ui/core';
import { useHistory } from "react-router-dom";


export default function Header(props) {  
  
  console.log(props.hidden,props.hidden1);
  const history=useHistory();
    const routeChangeToHome = () =>{ 
        history.push('/');
      }
    const routeChangeToCart = () =>{ 
    history.push('/cart');
  }
  const routeChangeToOrders = () =>{ 
    history.push('/orders');
  }
  const routeChangeToProfile = () =>{ 
    history.push('/profile');
  }

  const routeChangeToLogout = () =>{ 
    localStorage.clear();
    history.push('/login');
    
  }
  const style = {
    color: 'white'
  };
  if(props.hidden)return null;
  if(props.hidden1) return null;
    return ( 
        <nav className="nav">
            <div className="logo" style={style}>Shop</div>
            <ul>
                
                <li><Button onClick={routeChangeToHome} style={style}>Home</Button></li>
                <li><Button onClick={routeChangeToCart} style={style}>Cart</Button></li>
                <li><Button onClick={routeChangeToOrders} style={style} >Orders</Button></li>
                <li><Button onClick={routeChangeToProfile} style={style}>Profile</Button></li>  
                <li><Button onClick={routeChangeToLogout} style={style} >Logout</Button></li>
            </ul>
        </nav> 
    );  
}