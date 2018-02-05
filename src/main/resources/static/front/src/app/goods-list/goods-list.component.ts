import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {GoodsServiceService} from "./goods-service.service";
import {Goods} from "./goods";
import {FrontServiceService} from "../front-service.service";
import {GoodsService} from "./goods-service";

@Component({
  selector: 'app-goods-list',
  templateUrl: './goods-list.component.html',
  styleUrls: ['./goods-list.component.css']
})
export class GoodsListComponent implements OnInit {

  cols: any[];
  newGoods: boolean;
  @Output('addedNewGoods') goodsUpdated = new EventEmitter();
  displayDialog: boolean;
  /*@Input('goodsForTable')*/
  goodsList: Goods[];
  selectedGoods: Goods;

  @Input('service')
  goodsService: GoodsService;

  constructor() {
  }

  getData(){
    this.goodsService.getGoodsList().subscribe(data=> this.goodsList = data)
    console.log(this.goodsList)
  }

  ngOnInit() {
    this.cols = [
      {field: 'id', header: 'Id'},
      {field: 'name', header: 'Name'},
      {field: 'price', header: 'Price'}
    ];

    this.getData();
    setInterval(() => this.getData(), 10000)
  }

  onRowSelect(event) {
    this.selectedGoods = event.data;
    console.log('goods selected! ');
    console.log('selected goods = ' + this.selectedGoods.id + " " + this.selectedGoods.name + " " + this.selectedGoods.price);
    this.displayDialog = true;
  }

  onRowUnselect(event) {
    this.selectedGoods = null;
    console.log('goods UNselected! ');
    console.log('selected goods = ' + this.selectedGoods);
  }

  showDialogToAdd() {
    this.newGoods = true;
    this.selectedGoods = new Goods();
    this.displayDialog = true;
  }

  addNewGoods(goods :Goods): void {

    if (!goods.name || !goods.price) {
      return;
    }
    goods.name = goods.name.trim();
    console.log(goods.name + ' ' + goods.price);
    this.goodsService.addNewGoods(goods).subscribe(
      () => this.goodsList.push(goods)
    );
    this.goodsUpdated.emit();
    this.newGoods = false;
  }

  update(goods: Goods): void {
    if (goods.id) {
      goods.name = goods.name.trim();
      if (!goods.name || !goods.price) {
        return;
      }
      console.log('trying to save cahanges ' + goods.name + ' ' + goods.price);
      let index = this.goodsList.indexOf(goods);
      this.goodsService.updateGoods(goods).subscribe(
        () =>  this.goodsList[this.goodsList.indexOf(this.selectedGoods)] = goods);
      this.goodsList[index] = goods;
    }
    else this.addNewGoods(goods);
    this.selectedGoods = null;
    this.displayDialog = false;
    this.goodsUpdated.emit();
  }

  delete() {
    let index = this.goodsList.indexOf(this.selectedGoods);
    this.goodsService.deleteGoods(this.selectedGoods as Goods).subscribe();
    this.goodsList = this.goodsList.filter((val, i) => i != index);
    this.selectedGoods = null;
    this.displayDialog = false;
    this.goodsUpdated.emit();

  }

}
