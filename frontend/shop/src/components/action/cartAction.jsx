// @flow
import {RECV_ITEMS} from './items.jsx';

export const INIT_CART: string = 'INIT_CART';
export const GET_CART: string = 'GET_CART';
export const RECV_CART: string = 'RECV_CART';
export const ERR_RECV_CART: string = 'ERR_RECV_CART';
export const CHECKOUT_CART: string = 'CHECKOUT_CART';
export const ADD_ITEM: string = 'ADD_ITEM';
export const SUB_ITEM: string = 'SUB_ITEM';

export class Action {
  type: string;
  item: Object;
  quantity: number;

  constructor(type: string, item: Object, quantity: number){
    this.type = type;
    this.item = item;
    this.quantity = quantity;
  }
}

function getHeaders(): Object{
  let authHeader = localStorage.getItem('authorization');
  let headers: Object = {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  };
  if(authHeader !== 'null'){
    headers.authorization = authHeader;
  }
  console.log(headers);
  return headers;
}

//TODO: implement function if cart is not empty and we retry a sync...
export function initCart(){
  return( (dispatch) => {
    let headers = getHeaders();
    dispatch(getCart());
    return fetch('/cart/', {
      method: 'GET',
      headers: headers
    })
    .then(
      (response) => {
        if(!response.ok){
          throw Error(response.statusText);
        }
        if(headers.authorization === 'null'){
          localStorage.setItem('authorization', response.headers.get('authorization'));
        }
        return response.json();
      })
    //add dispatch here for fetched card items
    .then(json => {
      dispatch(receivedCart(json));
      dispatch(receivedItems(json));
    })
    .catch((error) => {
      console.log('Could not initialize cart.', error);
      dispatch(errorReceiveCart());
    });
  });
}

function getCart(){
  return {type: GET_CART};
}

function receivedCart(cart){
  return {type: RECV_CART, cart: cart};
}

function receivedItems(cart){
  return {type: RECV_ITEMS, items: cart.items};
}

function errorReceiveCart(){
  return {type: ERR_RECV_CART};
}
