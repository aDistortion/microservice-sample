// @flow
import React from 'react';
import {Container} from '../layout/generic.jsx';
import {connect} from 'react-redux';
import {addItem} from '../action/cartAction.jsx';

export default class Cart extends React.Component {
  props: any;

  render(){
    return(
      <Container>
        <ItemTable />
        <button type="button" className="btn btn-success pull-right" >Checkout</button>
      </Container>
    );
  }
}

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
            <td>{productItems.reduce((sum, item) => sum+item.price*item.quantity, 0)}</td>
          </tr>
        </tbody>
      </table>
    );
  }
}
const mapStateToProps = (state) => ({
  items: state.cart.items,
  products: state.shop.products
})

//TODO: propagate onAddItem to ItemRow
const mapDispatchToProps = {
  onAddItem: addItem
}

const ItemTable = connect(mapStateToProps, mapDispatchToProps)(ItemTableContainer);

//TODO: add a button for increasing/decreasing the quantity
class ItemRow extends React.Component {
  render(){
    return(
      <tr>
        <td>{this.props.name}</td>
        <td>{this.props.quantity}</td>
        <td>{this.props.price}</td>
        <td>{(this.props.quantity * this.props.price).toFixed(2)}</td>
      </tr>
    );
  }
}
