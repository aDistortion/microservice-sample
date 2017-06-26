import React from 'react';
import { Link } from 'react-router-dom';

export default class LoginButton extends React.Component {
  render() {
    const msg = this.props.isAuthenticated ? 'Logout' : 'Login' ;
    return(
     <AuthButton msg={msg} handleClick={this.props.handleClick}/>
    )}
}
class AuthButton extends React.Component {
  render(){
    const handleClick = this.props.handleClick;
    return(
      <Link to="/" className="btn btn-success" onClick={handleClick}>{this.props.msg}</Link>
    )}
}
// LoginButton = withRouter(LoginBtn);