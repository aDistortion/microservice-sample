// @flow

import { combineReducers } from 'redux';
import { RECV_PRODUCTS } from '../action/productAction.jsx';

const products = (state: Array<Object> = [], action: Object) => {
  let newState = [...state];
  switch(action.type){
    case RECV_PRODUCTS:
      newState.push(...action.products);
  }
  return newState;
}

export default products;