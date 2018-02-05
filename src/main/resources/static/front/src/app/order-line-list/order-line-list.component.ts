import {Component, Input, OnInit} from '@angular/core';
import {OrderLine} from "./orderLine";
import {OrderLineService} from "./order-line-service";

@Component({
  selector: 'app-order-line-list',
  templateUrl: './order-line-list.component.html',
  styleUrls: ['./order-line-list.component.css']
})
export class OrderLineListComponent implements OnInit {

  @Input('orderID')
  orderId: number;
  orderLineList: OrderLine[];
  selectedOrderLine: OrderLine;
  newOrderLine: boolean;
  @Input('service')
  service: OrderLineService;
  cols: any[];

  constructor() {
  }

  ngOnInit() {
    this.cols = [
      {field: 'id', header: 'Id'},
      {field: 'orderId', header: 'Order ID'},
      {field: 'goodsId', header: 'Goods ID'},
      {field: 'count', header: 'Count'}
    ]
  }

}
