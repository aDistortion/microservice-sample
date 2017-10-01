// @flow

export const ADD_ITEM: string = 'ADD_ITEM';
export const SUB_ITEM: string = 'SUB_ITEM';
export const RECV_ITEMS: string = 'RECV_ITEMS';

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

//TODO: make this pure again, trigger update on cart action, set cartSync flag if update fails
export function addItem(item: Object, quantity: number): Object{
  return ((dispatch) => {
    let headers = getHeaders();
    let itemDto = {uuid: item.uuid, quantity: quantity};
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
    .catch(error => console.log('Could not add item into remote cart.', error))
    .then(json => dispatch({type: ADD_ITEM, item: itemDto}));
  })
}

export function removeItem(item: Object, quantity: number): Object{
  let itemDto = {uuid: item.uuid, quantity: quantity};
  return {type: SUB_ITEM, item: itemDto};
}
