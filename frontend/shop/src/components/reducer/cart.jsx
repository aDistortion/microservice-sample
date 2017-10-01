// @flow

import {RECV_CART, GET_CART, ERR_RECV_CART} from '../action/cartAction.jsx';
import { combineReducers } from 'redux';
import cartItems from './cartItems.jsx';

const initCart = {
  isFetching: false,
  isInSync: false,
  postingItem: false
}

const cartReducer = (state: Object = initCart, action: Object) => {
  let newState = Object.assign({}, state);
  switch(action.type){
    case GET_CART:
      newState.isFetching = true;
      newState.getItem = false;
      newState.isInSync = false;
      break;
    case RECV_CART:
      newState.isFetching = false;
      newState.getItem = false;
      newState.isInSync = true;
      break;
    case ERR_RECV_CART:
      newState.isFetching = false;
      newState.getItem = false;
      newState.isInSync = false;
      break;
  }
  return newState;
}

const cart = combineReducers({
    app: cartReducer,
    items: cartItems
});

export default cart;
