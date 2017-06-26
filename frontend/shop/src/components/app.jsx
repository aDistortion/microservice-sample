import React from 'react';
import 'jquery';
import 'bootstrap/dist/js/bootstrap';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';

export default class App extends React.Component {
  render() {
    return(
      <AppRouter />
    )}
}

class AppRouter extends React.Component {
  render(){
    return(
    <Router>
      <nav className="navbar navbar-default">
        <div className="container-fluid">
          <div className="navbar-header">
            <button type="button" className="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span className="sr-only">Toggle navigation</span>
              <span className="icon-bar"></span>
              <span className="icon-bar"></span>
              <span className="icon-bar"></span>
            </button>
            <a className="navbar-brand" href="#">Sample Shop</a>
          </div>
          <div id="navbar" className="navbar-collapse collapse">
            <ul className="nav navbar-nav">
              <li><Link to="/">Dashboard</Link></li>
              <li><Link to="/ship">Shipping</Link></li>
              <li><Link to="/bill">Billing</Link></li>
            </ul>
            <ul className="nav navbar-nav navbar-right">
              <li><Link to="/user">Account</Link></li>
              <li><Link to="/history">History</Link></li>
              <li><Link to="/logout">Logout</Link></li>
            </ul>
          </div>
        </div>
        <Route exact path="/" component={Cont1}/>
        <Route path="/ship" component={Cont2}/>
        <Route path="/bill" component={Cont1}/>
        <Route path="/user" component={Cont1}/>
        <Route path="/history" component={Cont1}/>
        <Route path="/logout" component={Cont1}/>
      </nav>
    </Router>
    )}
}

const Cont1 = () => (
    <div className="container">
      <div className="row">
      <div className="col-xs-12 text-center">
        <h1>Hello World!</h1>
        <p className="text-center">Just a test...</p>
        <span className="glyphicon glyphicon-star"></span>
      </div>
      </div>
    </div>
)

const Cont2 = () => (
    <div className="container">
      <div className="row">
      <div className="col-xs-12 text-center">
        <h1>Hello World 2!</h1>
        <p className="text-center">Just another test...</p>
        <span className="glyphicon glyphicon-star"></span>
      </div>
      </div>
    </div>
)