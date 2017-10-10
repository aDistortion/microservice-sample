import React from 'react';
import {Col} from '../layout/generic.jsx';
import {connect} from 'react-redux';
import {addItem} from '../action/items.jsx';

export class ProductContainer extends React.Component{
  constructor(props){
    super(props);
    this.addToCart = this.addToCart.bind(this);
    this.changeQuantity = this.changeQuantity.bind(this);
    this.state = {quantity: 1}
  }

  changeQuantity(event){
    this.setState({quantity: Number.parseInt(event.target.value, 10)});
  }

  addToCart(event){
    event.preventDefault();
    this.props.onAddToCart(this.props.item, this.state.quantity);
    this.setState({quantity: 1});
  }

  render(){
    return(
      <div className="panel panel-default">
        <div className="panel-body" style={{padding: 10+'px', height: 275+'px'}}>
          <Col lg="6" md="6" xs="7">
            <div className="placeholder" style={{width: 100+'%', height: 250+'px'}} ></div>
          </Col>
          <Col lg="6" md="6" xs="5" style={{padding: 0+'px'}}>
            <ul style={{listStyleType: 'none', padding: 0}}>
              <li style={{fontSize: 1.2+'em'}}>{this.props.item.vendor}</li>
              <li><strong>{this.props.item.name}</strong></li>
              <li>{this.props.item.type}</li>
              <li>{this.props.item.country}</li>
              <li><strong>{this.props.item.price}</strong> <span className="glyphicon glyphicon-yen" aria-hidden="true"></span></li>
              <li><StockLabel quantity={this.props.item.stock}/></li>
            </ul>
            <form className="text-center" onSubmit={this.addToCart}>
              <div className="form-group">
                <input type="number" className="form-control" id="quantityInput" min="0" value={this.state.quantity} onChange={this.changeQuantity}></input>
              </div>
              <button type="submit" className="btn btn-success" style={{width: 100+'%'}} ><span className="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Add to cart</button>
            </form>
          </Col>
        </div>
      </div>
    );
  }
}

class StockLabel extends React.Component{
  render(){
    let state = "warning";
    let text = this.props.quantity + " Available";
    if(this.props.quantity > 3){
      state = "success";
    }else if(this.props.quantity <= 0){
      state = "danger";
      text = "Out of stock";
    }else if(this.props.quantity == null){
      text = "Currently not available"
    }
    return(
      <span className={"label label-"+state}>{text}</span>
    );
  }
}

const mapDispatchToProps = {
  onAddToCart: addItem
};
  
export const ProductCard = connect(null,mapDispatchToProps)(ProductContainer);