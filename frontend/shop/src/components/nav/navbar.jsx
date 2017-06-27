import React from 'react';
import LoginButton from '../auth/login.jsx';
import { BrowserRouter as Router, Switch, Link, Route } from 'react-router-dom';
import { NavbarLinksList, AppSwitch } from './routes.jsx';

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
                <NavbarLinksList className="nav navbar-nav" authRequired={false} />
                <ul className="nav navbar-nav navbar-right">
                  { this.state.isAuthenticated ? 
                    <li className="dropdown">
                      <a href="#" className="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Profile <span className="caret"></span></a>
                      <NavbarLinksList className="dropdown-menu" authRequired={true}>
                        <li role="separator" className="divider"></li>
                        <li className="dropdown-header">Account</li>
                        <li><Link to="/user">Settings</Link></li>
                        <li><LoginButton isAuthenticated={this.state.isAuthenticated} handleClick={this.handleClick}/></li>
                      </NavbarLinksList>
                    </li>
                  :
                    <li><LoginButton isAuthenticated={this.state.isAuthenticated} handleClick={this.handleClick}/></li>
                  }
                </ul>
              </div>
            </div>
          </nav>
          <AppSwitch isAuthenticated={this.state.isAuthenticated} />
        </div>
      </Router>
    )}
}
