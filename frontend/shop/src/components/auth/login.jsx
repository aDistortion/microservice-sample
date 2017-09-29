import React from 'react';
import { Link } from 'react-router-dom';

export default class LoginButton extends React.Component {
  render() {
    const msg = this.props.isAuthenticated ? 'Logout' : 'Login' ;
    return(
      <Link to="/" onClick={this.props.handleClick}>{msg}</Link>
    )}
}
