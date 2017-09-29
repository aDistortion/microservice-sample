// @flow

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

export function addItem(item: Object, quantity: number): Object{
  return buildAction(ADD_ITEM, item, quantity);
}

export function removeItem(item: Object): Object{
  return buildAction(SUB_ITEM, item, 1);
}

export function buildAction(type: string, item: Object, quantity: number): Object{
  return {type, item, quantity};
}