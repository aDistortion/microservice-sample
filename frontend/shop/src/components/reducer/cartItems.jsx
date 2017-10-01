// @flow
import {ADD_ITEM, SUB_ITEM, RECV_ITEMS} from '../action/items.jsx';

const cartItems = (state: Array<Object> = [], action: Object) => {
  let newState = [...state];
  let item = {};
  switch(action.type){
    case RECV_ITEMS:
      newState = action.items;
      break;
    case ADD_ITEM:
      item = newState.filter(item => (item.uuid == action.item.uuid))[0];
      if(item != null){
        item.quantity += action.item.quantity;
      }else{
        newState.push(action.item);
      }
      break;
    case SUB_ITEM:
      item = newState.filter(item => (item.uuid == action.item.uuid))[0];
      if(item != null){
        item.quantity -= action.item.quantity;
      }
      break;
    }
    return newState;
}

export default cartItems;