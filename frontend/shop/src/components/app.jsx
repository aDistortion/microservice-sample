import React from 'react';
import 'jquery';
import 'bootstrap/dist/js/bootstrap';
import AppRouter from './nav/navbar.jsx';
import Shop from './sites/shop.jsx';
import Dashboard from './sites/dashboard.jsx';
import Billing from './sites/billing.jsx';
import Shipping from './sites/shipping.jsx';
import History from './sites/history.jsx';

const routes = [
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

export default class App extends React.Component {
  constructor(props){
    super(props);
    this.state = {isAuthenticated: false};
  }

  render() {
    return(
      <AppRouter routes={routes} isAuthenticated={this.state.isAuthenticated}/>
    )}
}
