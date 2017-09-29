import React from 'react';
import {Container, Row, Col} from '../layout/generic.jsx';
import {ConnectedItemCard} from '../container/item.jsx';

export default class Shop extends React.Component{
  render(){
    let items = [
      {
        vendor: "Golser Brauerei",
        name: "Green Goose",
        type: "Craft Beer",
        country: "Austria",
        price: "4.99",
        stock: 12,
        uuid: "green-goose"
      },
      {
        vendor: "De Brabandere",
        name: "Petrus",
        type: "Aged Pale Ale",
        country: "Belgium",
        price: "7.99",
        stock: 3,
        uuid: "petrus"
      },
      {
        vendor: "Hacker-Pschorr",
        name: "Münchner Hell",
        type: "Light Lager",
        country: "Germany",
        price: "2.99",
        stock: 0,
        uuid: "muenchner-hell"
      },
    ];
    return(
      <Container>
        <h1>Sample Shop <small>Buy more!</small></h1>
        <hr/>
        <Row>
          <Col lg="4" md="4" xs="12">
            <ConnectedItemCard item={items[0]} />
          </Col>
          <Col lg="4" md="4" xs="12">
            <ConnectedItemCard item={items[1]} />
          </Col>
          <Col lg="4" md="4" xs="12">
            <ConnectedItemCard item={items[2]} />
          </Col>
        </Row>
      </Container>
    );
  }
}
