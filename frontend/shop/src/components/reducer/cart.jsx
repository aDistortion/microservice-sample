// @flow
import {Action, ADD_ITEM, SUB_ITEM} from '../action/cartAction.jsx';

const initialState: Object = {
  cart: {
    cartId: '',
    items: []
  },
  user: {
    displayName: 'Anonymous',
    id: '',
    isAuthenticated: false
  }
}

export function cartApp(state: Object = initialState, action: Object): Object {
  console.log("Action: "+action.type+", "+action.quantity);
  let newState = Object.assign({}, state);
  switch(action.type){
    case ADD_ITEM:
      let items = newState.cart.items.filter(item => (item.uuid == action.item.uuid));
      if(items[0] != null){
        console.log('Updating item...')
        items[0].quantity += action.quantity;
      }else{
        console.log('Adding new item...');
        let item = action.item;
        item.quantity = action.quantity;
        newState.cart.items.push(item);
      }
      break;
    case SUB_ITEM:
      break;
    }
    console.log(newState);
    return newState;
}
