import React from 'react';
import {Container, Row, Col} from '../layout/generic.jsx';
import {ConnectedItemCard} from '../container/item.jsx';
import {connect} from 'react-redux';

class ShopContainer extends React.Component{
  render(){
    return(
      <Container>
        <h1>Sample Shop <small>Buy more!</small></h1>
        <hr/>
        <Row>
            {
              this.props.products.map(product => {
                <Col lg="4" md="4" xs="12">
                  <ConnectedItemCard item={product} />
                </Col>
              })
            }
        </Row>
      </Container>
    );
  }
}

//FIXME: state is not reflected, props are empty...
const mapStateToProps = (state) => ({
  products: state.shop.products
})

const Shop = connect(mapStateToProps)(ShopContainer);
export default Shop;
