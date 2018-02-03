import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {GoodsServiceService} from "../goods-service.service";
import {Goods} from "../goods";

@Component({
  selector: 'app-goods-add-form',
  templateUrl: './goods-add-form.component.html',
  styleUrls: ['./goods-add-form.component.css']
})
export class GoodsAddFormComponent implements OnInit {

  @Input('service')
  goodsService :GoodsServiceService

  constructor() { }


  @Output('addedNewGoods') goodsUpdated = new EventEmitter();

  ngOnInit() {
  }

  add(name: string, price: number): void {
    name = name.trim();
    if (!name||!price) { return; }
    console.log(name + ' ' + price);
    this.goodsService.addNewGoods({name, price} as Goods).subscribe();
    this.goodsUpdated.emit();
  }



}
