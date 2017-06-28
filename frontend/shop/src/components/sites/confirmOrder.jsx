import React from 'react';
import {withRouter} from "react-router-dom";
import { OrderProcessService } from "../api/processEngine.jsx";
import { CartTable, ProductRow } from "../table/order.jsx";

const processService = new OrderProcessService;

class ConfirmOrder extends React.Component{
  constructor(props){
    super(props);
    this.state = {order : {lineItems: []}, task: {}};
    this.fetchVariables = this.fetchVariables.bind(this);
    this.fetchTask = this.fetchTask.bind(this);
    processService.fetchInstanceVariables(this.props.match.params.instanceId, this.fetchVariables);
    processService.fetchTask(this.props.match.params.instanceId, this.fetchTask);
  }

  fetchVariables(variables){
    this.setState({order: variables.order});
  }

  fetchTask(task){
    debugger;
    this.setState({task: task[0]});
  }

  render(){
    return(
      <div className="container">
        <div className="row text-center">
          <h1>Cofirm order</h1>
          <div className="col-xs-12" style={{padding: 5+'px'}}>
            <h2 className="text-center">Your order</h2>
            <form onSubmit={event => {
              event.preventDefault();
              let currentTask = this.state.task;
              var history = this.props.history;
              processService.completeTask(currentTask.id, (instance) => {
                console.log("Order sent");
                history.push('/order/'+instance.id+'/address');
              });
            }}>
            <CartTable>
              {
                this.state.order.lineItems.map((product) => (
                  <ProductRow product={product} />
                ))
              }
            </CartTable>
          <button className="btn btn-success" type="submit">Confirm</button>
          </form>
          </div>
        </div>
      </div>
    );
  }
}

export default withRouter(ConfirmOrder);