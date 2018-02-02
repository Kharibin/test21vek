import {Component, Input, OnInit} from '@angular/core';
import {GoodsServiceService} from "../goods-service.service";
import {Goods} from "../goods";

@Component({
  selector: 'app-goods-list',
  templateUrl: './goods-list.component.html',
  styleUrls: ['./goods-list.component.css'],
  providers: [GoodsServiceService]
})
export class GoodsListComponent implements OnInit {

  @Input('goodsForTable')
  goodsList: Goods[];

  @Input('service')
  goodsService :GoodsServiceService;

  constructor(){ }

  ngOnInit() {/*
    this.getData();
    setInterval(() => this.getData(), 10000)*/
  }

}
