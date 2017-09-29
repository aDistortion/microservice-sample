import React from 'react';

export class CartTable extends React.Component{
  constructor(props){
    super(props);
  }
  render(){
    return(
      <table className="table table-hover">
        <thead>
          <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Amount</th>
            <th>Total</th>
          </tr>
        </thead>
        <tbody>
          {this.props.children}
        </tbody>
      </table>
    );
  }
}

export class ProductRow extends React.Component{
  render(){
    return(
      <tr key={this.props.product.uuid}>
        <td className="text-left">{this.props.product.name}</td>
        <td className="text-left">{this.props.product.description}</td>
        <td className="text-right">{this.props.product.price} <span className="glyphicon glyphicon-yen" aria-hidden="true"></span></td>
        <td className="text-left">{this.props.product.amount}</td>
        <td className="text-left">{this.props.product.total}</td>
      </tr>
    );
  }
}

export class PendingOrderTable extends React.Component{
  render(){
    return(
      <table className="table table-hover">
        <thead>
          <tr>
            <th>Order Reference</th>
            <th>State</th>
            <th>Expected arrival</th>
            <th>Total</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1234</td>
            <td>Delayed</td>
            <td>25. 06. 2017</td>
            <td>350 EUR</td>
          </tr>
          <tr>
            <td>1234</td>
            <td>Delayed</td>
            <td>25. 06. 2017</td>
            <td>350 EUR</td>
          </tr>
          <tr>
            <td>1234</td>
            <td>Delayed</td>
            <td>25. 06. 2017</td>
            <td>350 EUR</td>
          </tr>
          <tr>
            <td>1234</td>
            <td>Delayed</td>
            <td>25. 06. 2017</td>
            <td>350 EUR</td>
          </tr>
        </tbody>
      </table>
    );
  }
}