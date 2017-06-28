import React from 'react';
import { PendingOrderTable } from '../table/order.jsx';

export default class Dashboard extends React.Component{
  render(){
    return(
    <div className="container">
      <div className="row text-center">
        <h1>Dashboard</h1>
        <div className="col-xs-6" style={{padding: 5+'px'}}>
          <h2 className="text-center">Pending orders</h2>
          <PendingOrderTable />
        </div>
        <div className="col-xs-6" style={{padding: 5+'px'}}>
          <h2 className="text-center">Sent</h2>
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
                <td>Shipped</td>
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
              <tr>
                <td>1234</td>
                <td>Delayed</td>
                <td>25. 06. 2017</td>
                <td>350 EUR</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>);
  }
}