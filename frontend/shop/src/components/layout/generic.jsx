import React from 'react';

export class Container extends React.Component {
  render(){
    return(
      <GenericContainer className="container">
        {this.props.children}
      </GenericContainer>
    );
  }
}

export class FluidContainer extends React.Component {
  render(){
    return(
      <GenericContainer className="container-fluid">
        {this.props.children}
      </GenericContainer>
    );
  }
}

export class Row extends React.Component {
  render(){
    return(
      <GenericContainer className="row">
        {this.props.children}
      </GenericContainer>
    );
  }
}

export class Col extends React.Component {
  render(){
    let clazz = "col-lg-"+this.props.lg+" "+"col-md-"+this.props.md+" "+"col-xs-"+this.props.xs;
    return(
      <GenericContainer className={clazz} style={this.props.style}>
        {this.props.children}
      </GenericContainer>
    );
  }
}

class GenericContainer extends React.Component {
  render(){
    return(
      <div className={this.props.className} style={this.props.style}>
        {this.props.children}
      </div>
    );
  }
}