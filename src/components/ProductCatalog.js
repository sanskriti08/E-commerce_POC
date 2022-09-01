import React, { useState, use } from 'react';
import { Link } from 'react-router-dom';
import { useParams } from 'react-router-dom'
// import "./catalog.css";
import axios from 'axios';
import Configuration from '../configurations/configuration';
import useFetch from './useFetch';

class ProductCatalog extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      product: [],
    }
    this.loadProduct = this.loadProduct.bind(this);
  }

  componentDidMount() {
var url_string = window.location;
var url = new URL(url_string);
var productId = this.props.match.params.productId;
    this.loadProduct(productId);
  }
  
  loadProduct(productId) {
   
    this.config = new Configuration();
    axios.get(`${this.config.BASE_URL}/product/${productId}`)
      .then((res) => {
        this.setState({ product: res.data })
        console.log("list of products"+JSON.stringify(this.state.product))

      });
  }

  handleAddToCart(item) {
    console.log(item);
    const id = item.id;
    const userName = localStorage.getItem("username");
    const usef=new useFetch();
    usef.handleAddTC(id,userName);  
    
}

  render() {
   
    return (
      (this.state.product.length !== 0) ?

        <div className="app">
       
            {/* // this.state.product.map(products =>  */}
            <div className="details" >
              <div className="big-img">
                <img id="featured" src={this.state.product.image} alt="" />
                <div className="img-display">
                  <div className="img-showcase">
                  </div>
                </div>
              </div>
              <div className="box">
                <div className="row">
                  <h2>{this.state.product.name}</h2>

                </div>
                <h2><span>${this.state.product.price}</span></h2>
          

                <p>{this.state.product.description}</p>
                
                <button className="cart" onClick={() => this.handleAddToCart(this.state.product)}>Add to cart</button>
              </div>
            </div>

    
     
          
        </div> :
        (
          <div>No Product</div>
        )
    );
  };

}

export default ProductCatalog;