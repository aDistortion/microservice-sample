// @flow

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
    .then(json => dispatch(receiveCart(json)))
    .catch((error) => {
      console.log('Could not initialize cart.', error);
      dispatch(errorReceiveCart());
    });
  });
}

function getCart(){
  return {type: GET_CART};
}

function receiveCart(cart){
  return {type: RECV_CART, cart: cart};
}

function errorReceiveCart(){
  return {type: ERR_RECV_CART};
}

export function addItem(item: Object, quantity: number): Object{
  return ((dispatch) => {
    let headers = getHeaders();
    let itemDto = item;
    itemDto.amount = quantity;
    return fetch('/cart/', {
      method: 'PUT',
      headers: headers,
      body: JSON.stringify(itemDto)
    })
    .then(response => {
      if(!response.ok){
        throw Error(response.statusText);
      }
      if(headers.authorization === 'null'){
        localStorage.setItem('authorization', response.headers.get('authorization'));
      }
      return response.json();
    })
    .then(json => dispatch(buildAction(ADD_ITEM, item, quantity)))
    .catch(error => console.log('Could not add item.', error));
  })
}

export function removeItem(item: Object): Object{
  return buildAction(SUB_ITEM, item, 1);
}

export function buildAction(type: string, item: Object, quantity: number): Object{
  return {type, item, quantity};
}