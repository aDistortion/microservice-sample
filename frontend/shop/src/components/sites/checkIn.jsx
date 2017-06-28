import React from 'react';
import {withRouter} from "react-router-dom";
import { OrderProcessService } from "../api/processEngine.jsx";

const processService = new OrderProcessService;

const products = [
  {
    id: 1,
    name: 'Goat1',
    description: 'Beautiful goat for less than a pesus!',
    price: 50
  },
  {
    id: 2,
    name: 'Goat3',
    description: 'Beautiful goat for less than a pesus!',
    price: 100
  },
  {
    id: 3,
    name: 'Goat3',
    description: 'Beautiful goat for less than a pesus!',
    price: 90
  },
];

class CheckIn extends React.Component{
  constructor(props){
    super(props);
    this.state = {checkedProducts: []};
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(e){
    let val = e.target.value;
    let name = e.target.name.split("_", 2);
    let product = products[name[1]];
    let checkedProducts = this.state.checkedProducts;
    //check if we already added this product to our list for check in
    let checkedIndex = checkedProducts.map(({id}) => id).indexOf(product.id);
    let checkedProduct = product;
    if(checkedIndex !== -1){
      checkedProduct = checkedProducts[checkedIndex];
    }
    checkedProduct.quantity = val;
    console.log(checkedProduct);
    if(checkedIndex !== -1){
      checkedProducts[checkedIndex] = checkedProduct;
    }else{
      checkedProducts.push(checkedProduct);
    }
    console.log(checkedProducts);
    this.setState({checkedProducts: checkedProducts});
  }

  render(){
    return(
    <div className="container">
      <div className="row text-center">
        <h1>Check-In</h1>
        <div className="col-xs-12" style={{padding: 5+'px'}}>
          <h2 className="text-center">Your cart</h2>
          <form onSubmit={event => {
              event.preventDefault();
              let order = {lineItems: this.state.checkedProducts};
              var history = this.props.history;
              processService.checkIn(order, (instance) => {
                console.log("Order created");
                history.push('/confirmOrder/'+instance.id);
              });
            }}>
          <table className="table table-hover table-striped table-highlight">
            <thead>
              <tr>
                <th>Image</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Amount</th>
              </tr>
            </thead>
            <tbody>
              {
                products.map((product, index) => (
                  <tr key={index}>
                    <td className="text-left">{product.id}</td>
                    <td className="text-left">{product.name}</td>
                    <td className="text-left">{product.description}</td>
                    <td className="text-right">{product.price} <span className="glyphicon glyphicon-yen" aria-hidden="true"></span></td>
                    <td><input type="number" className="form-control" name={'quantity_'+index} onChange={this.handleChange} style={{width: 'auto'}}></input></td>
                  </tr>
                ))
              }
            </tbody>
          </table>
          <button className="btn btn-success pull-right" type="submit">Check-In now</button>
          </form>
        </div>
      </div>
    </div>);
  }
}

export default withRouter(CheckIn);