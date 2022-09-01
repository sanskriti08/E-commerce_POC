import React from 'react';
import { Button } from '@material-ui/core';
import { withRouter } from 'react-router-dom';
import ProductService from '../services/ProductService';
import { Component } from 'react';
import { Route,Redirect } from "react-router-dom";
import useFetch from './useFetch';
class MainContent extends Component{
    
    constructor(props){
        
        super(props);
        this.state = {productItems:[]};
    }

    componentDidMount(){
        
        const productService = new ProductService();
        productService.fetchProducts().then((data) => {
            this.setState({productItems : data})
            console.log("inside product_data.js file"+this.state.productItems);
        });
    };
    
    
    

      routeChangeToProductCatalog(item){ 
        this.props.history.push({
            pathname: `/ProductCatalog/${item.id}`,
            
        });
        
      }

      handleAddToCart(item) {
        console.log(item);
        const id = item.id;
        const userName = localStorage.getItem("username");
        const usef=new useFetch();
        usef.handleAddToCar(id,userName);
    }
    
	render()
    {
        const productItems = this.state.productItems;
        const listItems = productItems.map((item) =>
        <div className="card" key={item.id}>
            <div className="card_img" >
                <img src={item.image} onClick={() => this.routeChangeToProductCatalog(item)} alt="card-img"/>
            </div>
            <div className="card_header">
                <h2>{item.name}</h2>
                <p>{item.description}</p>
                <p className="price">{item.price}<span>$</span></p>
                
                <Button className="btn" color="default" onClick={() => this.handleAddToCart(item)}>Add to cart</Button>
            </div>
        </div> 
        )
       return(
        <div className="main_content">
          
        {localStorage.getItem("username")!==null? listItems:<Redirect to='/login' />}
    
    </div>
       )
    }
    

}
export default withRouter(MainContent);
