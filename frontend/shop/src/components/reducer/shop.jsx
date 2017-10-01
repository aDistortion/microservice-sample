// @flow

import { combineReducers } from 'redux';
import { FETCHING_PRODUCTS, ERR_RECV_PRODUCTS, FETCHED_PRODUCTS } from '../action/shopAction.jsx';
import products from './products.jsx';

const initShop = {
    fetchingProducts: false,
    productsError: false
}

const shopReducer = (state: Object = initShop, action: Object) => {
  let newState = Object.assign({}, state);
  switch(action.type){
    case FETCHING_PRODUCTS:
      newState.fetchingProducts = true;
      newState.productsError = false;
      break;
    case ERR_RECV_PRODUCTS:
      newState.fetchingProducts = false;
      newState.productsError = true;
      break;
    case FETCHED_PRODUCTS:
      newState.fetchingProducts = false;
      newState.productsError = false;
      break;
  }
  return newState;
}

const shop = combineReducers({
    app: shopReducer,
    products: products
});

export default shop;