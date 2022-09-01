import React, { Component } from 'react';
import Typography from '@material-ui/core/Typography';
import '../App.css';
import Accordion from '@material-ui/core/Accordion';
import AccordionSummary from '@material-ui/core/AccordionSummary';
import AccordionDetails from '@material-ui/core/AccordionDetails';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import Button from '@material-ui/core/Button';
import OrderService from '../services/OrderService';

class OrderList extends Component{

    constructor(props){
        super(props);
        this.state = {orderItems:[]};
    }

    componentDidMount(){
        const orderService = new OrderService();
        orderService.fetchUserOrders().then((data) => {
            console.log(data);
            this.setState({orderItems : data})
            console.log(this.state.orderItems);
        });
    }

    render(){
        return (this.state.orderItems.length === 0) ? (
            <Typography variant="h5">
                No Orders to display. Please place some orders
            </Typography>
        ) : 
        (
            <div className="orderList">
                {this.state.orderItems.map(item => (
                    <Order item = {item}></Order>
                ))}
            </div>
        )
    }
}

function Order(props){
    return (
        <div>
            <Accordion className="order">
                <AccordionSummary expandIcon={<ExpandMoreIcon />}>
                    <OrderItem item = {props.item}></OrderItem>
                </AccordionSummary>
                <AccordionDetails >
                    <OrderDetails item = {props.item} ></OrderDetails>
                </AccordionDetails>
            </Accordion>
        </div>
    )
}

function OrderItem(props){
    var buttonStyle;
    if(props.item.orderStatus === "Delivered"){
        buttonStyle = {
            color : 'white',
            backgroundColor : '#33ab26'
        }
    } else if(props.item.orderStatus === "Shipped" || props.item.orderStatus === "Ordered"){
        buttonStyle = {
            color : 'white',
            backgroundColor : '#f0c60a'
        }
    }
    return (
        <div className="orderitem">
            <div className="productId">
                <Typography variant="h5" className = "accordion-content">
                    {props.item.product.id}
                </Typography>
            </div>
            <div className="productName">
                <Typography variant="h5" className = "accordion-content">
                    {props.item.product.name}
                </Typography>
            </div>
            <div className="amount">
                <Typography variant="h5" className = "accordion-content">
                    {props.item.totalAmount}
                </Typography>
            </div>
            <div className="status">
                <Button variant="contained" disabled style = {buttonStyle}>
                    <Typography variant="h5">
                        {props.item.orderStatus}
                    </Typography>
                </Button>
            </div>
        </div>
    )
}

function OrderDetails(props){
    let delivery;
    if(props.item.orderStatus === "delivered"){
        delivery = <h4>Delivered at {props.item.deliveredDate}</h4>
    } else if(props.item.orderStatus === "shipped" || props.item.orderStatus === "ordered"){
        delivery = <h4>Estimated delivery at {props.item.estimated}</h4>
    }
    return (
        <div>
            <div>{delivery}</div>
            <div className="productInDetail">
                <img className = "order_image" src = {props.item.product.image} alt="iphone"></img>
                <a href="/catalog">{props.item.product.name}</a>
            </div>
        </div>
    )
}

export default OrderList;