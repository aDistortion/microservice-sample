// @flow
import React from 'react';
import {connect} from 'react-redux';

class ItemTableContainer extends React.Component {
  render(){
    //two dimensional array returned so we need to get the first element which is returned by second map call...
    let productItems = this.props.items.map(
      item => this.props.products.filter(
        product => product.uuid == item.uuid)
        .map(product => {
          let productItem = product;
          productItem.quantity = item.quantity;
          return productItem;
        })[0]);
    return(
      <table className="table table-striped">
        <thead>
          <tr>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Item Price</th>
            <th>Total</th>
          </tr>
        </thead>
        <tbody>
          {
            productItems.map(item => <ItemRow key={item.uuid} name={item.name} quantity={item.quantity} price={item.price}/>)
          }
          <tr>
            <td>Total</td>
            <td>{productItems.reduce((sum, item) => sum+item.quantity, 0)}</td>
            <td>-</td>
            <td>{productItems.reduce((sum, item) => sum+item.price*item.quantity, 0)} <span className="glyphicon glyphicon-yen" aria-hidden="true"></span></td>
          </tr>
        </tbody>
      </table>
    );
  }
}

//TODO: add a button for increasing/decreasing the quantity
class ItemRow extends React.Component {
  render(){
    return(
      <tr>
        <td>{this.props.name}</td>
        <td>{this.props.quantity}</td>
        <td>{this.props.price} <span className="glyphicon glyphicon-yen" aria-hidden="true"></span></td>
        <td>{(this.props.quantity * this.props.price).toFixed(2)} <span className="glyphicon glyphicon-yen" aria-hidden="true"></span></td>
      </tr>
    );
  }
}

const mapStateToProps = (state) => ({
  items: state.cart.items,
  products: state.shop.products
})

const ItemTable = connect(mapStateToProps)(ItemTableContainer);
export default ItemTable;