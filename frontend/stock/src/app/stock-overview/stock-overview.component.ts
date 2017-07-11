import { Component, OnInit } from '@angular/core';
import { StockItem } from '../stockItem';

export const ITEMS: StockItem[] = [
  {id: 1, name: "Beer", onStock: 10},
  {id: 2, name: "Craft Beer", onStock: 10},
  {id: 3, name: "Pale Ale", onStock: 10},
  {id: 4, name: "Cider", onStock: 10},
  {id: 5, name: "Not Beer", onStock: 10},
]

@Component({
  selector: 'app-stock-overview',
  templateUrl: './stock-overview.component.html',
  styleUrls: ['./stock-overview.component.css']
})
export class StockOverviewComponent implements OnInit {

  items = ITEMS;

  constructor() { }

  ngOnInit() {
  }

}
