import React from 'react';
import LoginButton from '../auth/login.jsx';
import { BrowserRouter as Router, Switch, Link, Route } from 'react-router-dom';
import { NavbarLinksList, AppSwitch } from './routes.jsx';
import { HttpClient } from '../api/httpClient.jsx';

export default class AppRouter extends React.Component {
  constructor(props){
    super(props);
    this.httpClient = new HttpClient;
    this.ctx = {};
    this.state = {isAuthenticated: props.isAuthenticated};
    this.handleLogin = this.handleLogin.bind(this);
    this.handleLogout = this.handleLogout.bind(this);
  }

  handleLogin(){
    this.httpClient.get('/order-process/rest/engine/default/user/admin/profile', (res) => (this.setState({isAuthenticated: true, profile: res})));
  }

  handleLogout(){
    this.setState({isAuthenticated: false, profile: {}});
  }

  render(){
    return(
      <Router>
        <div>
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
                <NavbarLinksList className="nav navbar-nav" authRequired={false} routes={this.props.routes} />
                <ul className="nav navbar-nav navbar-right">
                  <li><Link to="/cart">Cart</Link></li>
                  { this.state.isAuthenticated ? 
                    <li className="dropdown">
                      <a href="#" className="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Profile <span className="caret"></span></a>
                      <NavbarLinksList className="dropdown-menu" authRequired={true} routes={this.props.routes}>
                        <li role="separator" className="divider"></li>
                        <li className="dropdown-header">{this.state.profile.id}</li>
                        <li><Link to="/user">Settings</Link></li>
                        <li><LoginButton isAuthenticated={this.state.isAuthenticated} handleClick={this.handleLogout}/></li>
                      </NavbarLinksList>
                    </li>
                  :
                    <li><LoginButton isAuthenticated={this.state.isAuthenticated} handleClick={this.handleLogin}/></li>
                  }
                </ul>
              </div>
            </div>
          </nav>
          <AppSwitch isAuthenticated={this.state.isAuthenticated} routes={this.props.routes} />
        </div>
      </Router>
    )}
}
