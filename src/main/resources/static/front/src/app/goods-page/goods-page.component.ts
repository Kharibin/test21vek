import {Component, OnInit} from '@angular/core';
import {GoodsServiceService} from "./goods-service.service";
import {Goods} from "./goods";

@Component({
  selector: 'app-goods-page',
  templateUrl: './goods-page.component.html',
  styleUrls: ['./goods-page.component.css'],
  providers: [GoodsServiceService]
})
export class GoodsPageComponent implements OnInit {
  goodsList: Goods[];

  constructor(protected goodsService :GoodsServiceService) {
    this.goodsService = goodsService;
  }

  getData(){
    this.goodsService.getGoodsList().subscribe(data=> this.goodsList = data)
    console.log(this.goodsList)
  }

  ngOnInit() {
    this.getData();
    setInterval(() => this.getData(), 10000)
  }

}
