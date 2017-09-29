// @flow
import {Action, ADD_ITEM, SUB_ITEM, RECV_CART, GET_CART, ERR_RECV_CART} from '../action/cartAction.jsx';

const initialState: Object = {
  cart: {
    //cartId: '',//not used as we identify a cart owner by the sent authorization header transparently
    items: []
  },
  user: {
    displayName: 'Anonymous',
    id: '',
    isAuthenticated: false
  },
  app: {
    fetchCart: false,
    cartSynced: false,
    postItem: false
  }
}

export function cartApp(state: Object = initialState, action: Object): Object {
  let newState = Object.assign({}, state);
  switch(action.type){
    case ADD_ITEM:
      let items = newState.cart.items.filter(item => (item.uuid == action.item.uuid));
      if(items[0] != null){
        items[0].amount += action.quantity;
      }else{
        let item = action.item;
        item.amount = action.quantity;
        newState.cart.items.push(item);
      }
      break;
    case SUB_ITEM:
      break;
    case RECV_CART:
      newState = Object.assign({}, state, {
        cart: action.cart,
        app: {fetchCart: false, getItem: false, cartSynced: true}
      });
      break;
    case GET_CART:
      newState = Object.assign({}, state, {
        app: {fetchCart: true, getItem: false, cartSynced: false}
      });
      break;
    case ERR_RECV_CART:
      newState = Object.assign({}, state, {
        app: {fetchCart: false, getItem: false, cartSynced: false}
      });
      break;
    }
    return newState;
}

