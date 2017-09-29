import React from 'react';
import ReactDOM from 'react-dom';
import App from './components/App.jsx';
import { createStore } from 'redux';
import { cartApp } from './components/reducer/cart.jsx';

const test = () => {

}

let store = createStore(
  cartApp,
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
);

ReactDOM.render(<App store={store} />, document.getElementById('root'));