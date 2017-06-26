import React from 'react';
import LoginButton from '../auth/login.jsx';
import { BrowserRouter as Router, Switch, Link, Route } from 'react-router-dom';

export default class AppRouter extends React.Component {
  constructor(props){
    super(props);
    this.state = {isAuthenticated: props.isAuthenticated};
    this.handleClick = this.handleClick.bind(this);
  }

  handleClick(){
    this.setState({isAuthenticated: !this.state.isAuthenticated});
  }

  render(){
    let loginButton = {};
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
              <ul className="nav navbar-nav">
                <li><Link to="/">Dashboard</Link></li>
                <li><Link to="/shipping">Shipping</Link></li>
              </ul>
              <ul className="nav navbar-nav navbar-right">
                <li><Link to="/history">History</Link></li>
                {this.state.isAuthenticated ? 
                  <li className="dropdown">
                    <a href="#" className="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Profile <span className="caret"></span></a>
                    <ul className="dropdown-menu">
                      <li><Link to="/billing">Billing</Link></li>
                      <li role="separator" className="divider"></li>
                      <li className="dropdown-header">Account</li>
                      <li><Link to="/user">Settings</Link></li>
                      <li><Link to="/logout">Logout</Link></li>
                    </ul>
                  </li>
                :
                  <LoginButton handleClick={this.handleClick}/>
                }
              </ul>
            </div>
          </div>
        </nav>
        <Switch>
          {
            this.props.routes.map((route, index) => (
            <Route
              key={index}
              path={route.path}
              exact={route.exact}
              component={route.main} />
          ))}
        </Switch>
        </div>
      </Router>
    )}
}
