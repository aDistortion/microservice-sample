import React from 'react';
import 'jquery';
import 'bootstrap/dist/js/bootstrap';
import AppRouter from './nav/navbar.jsx';
import Dashboard from './dashboard.jsx';

export default class App extends React.Component {
  constructor(props){
    super(props);
    this.state = {isAuthenticated: false};
  }

  render() {
    let routes = [
      { path: '/',
        exact: true,
        main: () => <Dashboard/>
      },
      { path: '/shipping',
        exact: true,
        main: () => <h2>Bubblegum</h2>
      },
      { path: '/billing',
        exact: true,
        main: () => <h2>Shoelaces</h2>
      },
      { path: '/history',
        exact: true,
        main: () => <h2>Bubblegum</h2>
      }
    ];
    return(
      <AppRouter routes={routes} isAuthenticated={this.state.isAuthenticated}/>
    )}
}
