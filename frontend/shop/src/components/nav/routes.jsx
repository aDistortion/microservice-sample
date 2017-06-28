import React from 'react';
import { Link, Switch, Route } from 'react-router-dom';

export class NavbarLinksList extends React.Component {
  constructor(props){
    super(props);
    this.filterByAuthenticated = this.filterByAuthenticated.bind(this);
  }

  filterByAuthenticated(route){
    return route.visible && route.authRequired == this.props.authRequired;
  }

  render(){
    let permittedRoutes = this.props.routes.filter(this.filterByAuthenticated);
    let links = [];
    permittedRoutes.forEach((route, index) => (links.push(<li key={index}><Link to={route.path}>{route.label}</Link></li>))); 
    return(
      <ul className={this.props.className}>
        {links}
        {this.props.children}
      </ul>
    );
  }
}

export class AppSwitch extends React.Component {
  constructor(props){
    super(props);
    this.filterByAuthenticated = this.filterByAuthenticated.bind(this);
  }
  filterByAuthenticated(route){
    return this.props.isAuthenticated || !route.authRequired;
  }
  
  render(){
    return(
      <Switch>
        {
          this.props.routes.filter(this.filterByAuthenticated).map((route, index) => (
          <Route
            key={index}
            path={route.path}
            exact={route.exact}
            component={route.main} />
        ))}
      </Switch>
    );
  }
}