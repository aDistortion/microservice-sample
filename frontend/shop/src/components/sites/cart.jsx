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
            this.props.items.map(item => <ItemRow key={item.uuid} name={item.name} quantity={item.amount} price={item.price}/>)
          }
          <tr>
            <td>Total</td>
            <td>{this.props.items.reduce((sum, item) => sum+item.amount, 0)}</td>
            <td>-</td>
            <td>{this.props.items.reduce((sum, item) => sum+item.price*item.amount, 0)}</td>
          </tr>
        </tbody>
      </table>
    );
  }
}
const mapStateToProps = (state) => ({
  items: state.cart.items
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
