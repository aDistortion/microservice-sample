// @flow
import { combineReducers } from 'redux';
import cart from './cart.jsx';
import shop from './shop.jsx';

const shopApp = combineReducers({
  cart,
  shop
})

export default shopApp