// @flow
import React from 'react';
import LoginButton from '../auth/login.jsx';
import { BrowserRouter as Router, Switch, Link, Route, browserHistory } from 'react-router-dom';
import { connect } from 'react-redux';

export default class ShopNavbar extends React.Component {

  render(){
    return(
      <nav className="navbar navbar-default">
        <div className="container-fluid">
          <div className="navbar-header">
            <button type="button" className="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span className="sr-only">Toggle navigation</span>
              <span className="icon-bar"></span>
              <span className="icon-bar"></span>
              <span className="icon-bar"></span>
            </button>
            <Link to="/" className="navbar-brand">Sample Shop</Link>
          </div>
          <div id="navbar" className="navbar-collapse collapse">
            <ul className="nav navbar-nav">
              <li><Link to="/">Shop</Link></li>
            </ul>
            <ConnectedNavContainer/>
          </div>
        </div>
      </nav>
    );
  }
}

class NavContainer extends React.Component {
  props: any;
  state: {
    isAuthenticated: boolean,
    profile: any
  };
  
  handleLogin: Function;
  handleLogout: Function;
  updateItemCounter: Function;

  //TODO: hydrate with server state, should be done with store.dispatch
  constructor(props){
    super(props);
    this.state = {isAuthenticated: props.isAuthenticated, profile: {}};
    this.handleLogout = this.handleLogout.bind(this);
  }

  handleLogout(event: Event){
    this.setState({isAuthenticated: false, profile: {}});
  }

  render(){
    let badgeColor = '#3a87ad';
    if(this.props.cartSynced == false || this.props.fetchingCart == true){
      badgeColor = '#999999';
    }
    return(
      <ul className="nav navbar-nav navbar-right">
        <li><Link to="/cart"><span className="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Cart <span className="badge" style={{backgroundColor: badgeColor}}>{this.props.itemCount}</span></Link></li>
        { this.state.isAuthenticated ? 
          <li className="dropdown">
            <a href="#" className="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Profile <span className="caret"></span></a>
            <ul className="dropdown-menu" authRequired={true} routes={this.props.routes}>
              <li><Link to="/history">History</Link></li>
              <li role="separator" className="divider"></li>
              <li className="dropdown-header">{this.state.profile.id}</li>
              <li><Link to="/user">Settings</Link></li>
              <li><LoginButton isAuthenticated={this.state.isAuthenticated} handleClick={this.handleLogout}/></li>
            </ul>
          </li>
        :
          <li><LoginButton isAuthenticated={this.state.isAuthenticated} /></li>
        }
      </ul>
    );
  }
}

const mapStateToProps = (state) => ({
  itemCount: state.cart.items.reduce((sum, item) => sum+item.quantity, 0),
  fetchingCart: state.cart.app.isFetching,
  cartSynced: state.cart.app.isInSync
});
const ConnectedNavContainer = connect(mapStateToProps)(NavContainer);