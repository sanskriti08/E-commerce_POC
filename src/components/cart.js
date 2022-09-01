import {
  Button,
  ButtonGroup,
  List,
  ListItem,
  ListItemSecondaryAction,
  ListItemText,
} from "@material-ui/core";
import DeleteIcon from "@material-ui/icons/Delete";

import AddIcon from "@material-ui/icons/Add";

import RemoveIcon from "@material-ui/icons/Remove";
import React from "react";
import CartService from "../services/CartServices";
import { Flag } from "@material-ui/icons";
import useFetch from "./useFetch";
import OrderService from "../services/OrderService";
export default function Cart() {
  const cartService = new CartService();
  const orderService = new OrderService();

  const buttonStyle = {
    backgroundColor : '#FFD814',
    left : "90%"
  }
  const [cart, setCart] = React.useState([]);
  const usef=new useFetch();
  React.useEffect(() => {
    loadCart();
  }, []);
  const loadCart = () => {
    cartService.fetchUserCart().then((data) => {
      setCart(data);
    });
  };


  const changeCount = (item,incrementFlag) => {
    console.log(item);
    const id = item.id;
    usef.changecount(incrementFlag,id,loadCart);
  
  };

  const remove = (item) => {
    console.log(item);
    const id = item.id;
    usef.removeItem(id,loadCart);
  
  };

  const placeOrder = () => {
    if(orderService.placeOrder()){
      console.log(cart);
      cart.map((item) => {
        const id = item.id;
        usef.removeItem(id,loadCart);
      })
      alert("Order Placed Successfully");
    }
  }

  
  return (
    (cart.length > 0) ? 
    <div >
      <List>
        {cart &&
          cart.map((item) => {
            return (
              <ListItem>
                <ListItemText
                  primary={item.productName}
                  secondary={`Price: ₹${item.price} x ${item.quantity}`}
                />
                <ListItemSecondaryAction>
                  {" "}
                  <span>₹{(item.quantity * item.price).toFixed(2)}</span>
                  <ButtonGroup
                    variant="text"
                    color="primary"
                    aria-label="text primary button group"
                  >
                    <Button
                      onClick={() => {
                        changeCount(item,false);
                      }}
                    >
                      <RemoveIcon />
                    </Button>

                    <Button
                      onClick={() => {
                        changeCount(item,true);
                      }}
                    >
                      <AddIcon />
                    </Button>

                    <Button
                      onClick={() => {
                        remove(item);
                      }}
                      color="secondary"
                    >
                      <DeleteIcon />
                    </Button>
                  </ButtonGroup>
                
                </ListItemSecondaryAction>
                <hr/>
              </ListItem>
            
            );
          }
          )}
      </List>
      <br/>
      <Button color = "primary" onClick = {() => {placeOrder()}} style = {buttonStyle}>Place Order</Button>
    </div> :
    <div>No Items in the cart</div>
  );
}
