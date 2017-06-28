import React from 'react';
import 'jquery';
import 'bootstrap/dist/js/bootstrap';
import AppRouter from './nav/navbar.jsx';
import Shop from './sites/shop.jsx';
import Dashboard from './sites/dashboard.jsx';
import Billing from './sites/billing.jsx';
import Shipping from './sites/shipping.jsx';
import History from './sites/history.jsx';
import CheckIn from './sites/checkIn.jsx';
import ConfirmOrder from './sites/confirmOrder.jsx';

const routes = [
  { path: '/',
    label: 'Shop',
    exact: true,
    main: () => <Shop/>,
    authRequired: false,
    visible: true
  },
  { path: '/dashboard',
    label: 'Dashboard',
    exact: true,
    main: () => <Dashboard/>,
    authRequired: true,
    visible: true
  },
  { path: '/cart',
    label: 'Cart',
    exact: true,
    main: () => <CheckIn/>,
    authRequired: true,
    visible: false
  },
  { path: '/confirmOrder/:instanceId',
    label: 'Confirm Order',
    exact: false,
    main: () => <ConfirmOrder />,
    authRequired: false,
    visible: false
  },
  { path: '/shipping',
    label: 'Shipping',
    exact: true,
    main: () => <h2>Bubblegum</h2>,
    authRequired: true,
    visible: true
  },
  { path: '/billing',
    label: 'Billing',
    exact: true,
    main: () => <h2>Shoelaces</h2>,
    authRequired: true,
    visible: true
  },
  { path: '/history',
    label: 'History',
    exact: true,
    main: () => <h2>Bubblegum</h2>,
    authRequired: true,
    visible: true
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
