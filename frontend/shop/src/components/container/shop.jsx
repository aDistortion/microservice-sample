import React from 'react';
import {Container, Row, Col} from '../layout/generic.jsx';
import {ProductCard} from './product.jsx';
import {connect} from 'react-redux';

//FIXME: render max 3 cols, not a col per item
class ShopContainer extends React.Component{
  render(){
    return(
      <Container>
        <h1>Sample Shop <small>Buy more!</small></h1>
        <hr/>
        <Row>
            {
              this.props.products.map(product => <Col lg="4" md="4" xs="12" key={product.uuid}><ProductCard item={product} /></Col>)
            }
        </Row>
      </Container>
    );
  }
}

const mapStateToProps = (state) => ({
  products: state.shop.products
})

const Shop = connect(mapStateToProps)(ShopContainer);
export default Shop;
