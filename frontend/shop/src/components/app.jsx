import React from 'react';
import 'jquery';
import 'bootstrap/dist/js/bootstrap';
import { Provider } from 'react-redux';
import { BrowserRouter as Router, Switch, Link, Route, browserHistory } from 'react-router-dom';
import { AppSwitch } from './nav/routes.jsx';
import ShopNavbar from './nav/navbar.jsx';
import Shop from './sites/shop.jsx';
import History from './sites/history.jsx';
import Cart from './sites/cart.jsx';
import Settings from './sites/settings.jsx';

const routes = [
  { path: '/',
    label: 'Shop',
    exact: true,
    main: () => <Shop/>,
    authRequired: false,
    visible: true
  },
  {
    path: '/settings',
    label: 'Settings',
    exact: true,
    main: () => <Settings/>,
    authRequired: true,
    visible: false
  },
  { path: '/cart',
    label: 'Cart',
    exact: true,
    main: () => <Cart/>,
    authRequired: false,
    visible: false
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
      <Provider store={this.props.store}>
        <Main/>
      </Provider>
    )}
}

class Main extends React.Component {
  render(){
    return(
      <main>
        <Router history={browserHistory}>
          <div>
            <ShopNavbar/>
            <Switch>
              <Route
                key={1}
                path="/"
                exact={true}
                component={Shop} />
                <Route
                  key={2}
                  path="/cart"
                  exact={true}
                  component={Cart} />
            </Switch>
          </div>
        </Router>
      </main>
    );
  }
}
/*
                <Route
                  key={3}
                  path="/history"
                  exact={true}
                  component={History} />
                <Route
                  key={4}
                  path="/settings"
                  exact={true}
                  component={Settings} />
*/