import React from 'react';
import ReactDOM from 'react-dom';
import App from './components/App.jsx';
import { createStore, applyMiddleware } from 'redux';
import thunkMiddleware from 'redux-thunk';
import { createLogger } from 'redux-logger';
import { cartApp } from './components/reducer/cart.jsx';
import { initCart } from './components/action/cartAction.jsx';

//adding dev tools and logging for development environment
let store;
if(process.env.NODE_ENV !== "production"){
  store = createStore(
    cartApp,
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__(),
    applyMiddleware(thunkMiddleware, createLogger())
  );
}else{
  store = createStore(
    cartApp,
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__(),
    applyMiddleware(thunkMiddleware)
  );
}
store.dispatch(initCart());
ReactDOM.render(<App store={store} />, document.getElementById('root'));