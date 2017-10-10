// @flow
import React from 'react';
import {connect} from 'react-redux';
import {Container} from '../layout/generic.jsx';
import {checkOut} from '../action/shopAction.jsx';
import ItemTable from './item.jsx';

export default class CartContainer extends React.Component {
  render(){
    return(
      <Container>
        <ItemTable />
        <CheckOutButton handleCheckOut={this.props.handleCheckOut}/>
      </Container>
    );
  }
}

class CheckOutButtonContainer extends React.Component {
  render(){
    return(<button type="button" className="btn btn-success pull-right" onClick={this.props.handleCheckOut} >Checkout</button>);
  }
}

const mapDispatchToProps = {
  handleCheckOut: checkOut
};

const CheckOutButton = connect(null, mapDispatchToProps)(CheckOutButtonContainer);