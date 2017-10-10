// @flow

export const CHECKOUT_CART: string = 'CHECKOUT_CART';

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

export function checkOut(){
  return((dispatch) => {
    fetch('/api/cart/startCheckOut/', {
      method: 'GET',
      headers: getHeaders()
    })
    .then(response => {
      if(!response.ok){
        throw Error(response.statusText);
      }
      return response.json();
    }).then(json => {
      console.log(json);
      window.location = json.url;
      //dispatch(checkOutAction(json));
    })
    .catch(error =>{
      console.log('WHAT?', error);
    })
  });
}

function checkOutAction(json: any){
  return {type: CHECKOUT_CART, json};
}