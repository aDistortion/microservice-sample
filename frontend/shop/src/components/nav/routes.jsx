import React from 'react';
import { Link, Switch, Route } from 'react-router-dom';
import Dashboard from '../sites/dashboard.jsx';
import Shop from '../sites/shop.jsx';

export const routes = [
  { path: '/',
    label: 'Shop',
    exact: true,
    main: () => <Shop/>,
    authRequired: false,
  },
  { path: '/dashboard',
    label: 'Dashboard',
    exact: true,
    main: () => <Dashboard/>,
    authRequired: true,
  },
  { path: '/shipping',
    label: 'Shipping',
    exact: true,
    main: () => <h2>Bubblegum</h2>,
    authRequired: true,
  },
  { path: '/billing',
    label: 'Billing',
    exact: true,
    main: () => <h2>Shoelaces</h2>,
    authRequired: true,
  },
  { path: '/history',
    label: 'History',
    exact: true,
    main: () => <h2>Bubblegum</h2>,
    authRequired: true,
  }
];

export class NavbarLinksList extends React.Component {
  constructor(props){
    super(props);
    this.filterByAuthenticated = this.filterByAuthenticated.bind(this);
  }

  filterByAuthenticated(route){
    return route.authRequired == this.props.authRequired;
  }

  render(){
    let permittedRoutes = routes.filter(this.filterByAuthenticated);
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
          routes.filter(this.filterByAuthenticated).map((route, index) => (
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