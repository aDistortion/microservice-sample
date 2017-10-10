// @flow

export const FETCHING_PRODUCTS: string = 'FETCHING_PRODUCTS';
export const ERR_RECV_PRODUCTS: string = 'ERR_RECV_PRODUCTS';
export const FETCHED_PRODUCTS: string = 'FETCHED_PRODUCTS';

export const RECV_PRODUCTS: string = 'RECV_PRODUCTS';

const headers: Object = {
  'Accept': 'application/json',
  'Content-Type': 'application/json'
}

export function fetchProducts(): Object{
  return (dispatch) => {
    dispatch({type: FETCHING_PRODUCTS});
    fetch('/api/product/', {
      method: 'GET',
      headers: headers
    })
    .then(response => {
      if(!response.ok){
        throw Error(response.statusText);
      }
      return response.json();
    })
    .catch(error => console.log('Could not fetch products.', error))
    .then(json => {
      dispatch({type: RECV_PRODUCTS, products: json});
      dispatch({type: FETCHED_PRODUCTS});
    })
  }
}