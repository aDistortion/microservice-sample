import React from 'react';
import 'jquery';
import 'bootstrap/dist/js/bootstrap';
import AppRouter from './nav/navbar.jsx';
import {routes} from './nav/routes.jsx';

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
