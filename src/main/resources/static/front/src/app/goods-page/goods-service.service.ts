import {Injectable, Output} from '@angular/core';
import {HttpClient, HttpEvent, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Goods} from "./goods";


/*const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};*/

@Injectable()
export class GoodsServiceService {


  constructor(private httpClient: HttpClient) { }

  getGoodsList():Observable<Goods[]>{
    return this.httpClient.get<Goods[]>('/allGoods'/*, httpOptions*/)
  }

  addNewGoods(goods :Goods) :Observable<Goods>{
    console.log(goods);
    return this.httpClient.post<Goods>('/addGoods', goods/*, httpOptions*/)
  }

  deleteGoods(goods :Goods) :Observable<Goods>{
    console.log('trying to delete ' + goods);
    return this.httpClient.post<Goods>('/deleteGoods', goods);
  }

  updateGoods(goods :Goods) :Observable<Goods>{
    console.log('trying to update Goods('+goods.id +')to ' + goods.name +' ' + goods.price);
    return this.httpClient.post<Goods>('/updateGoods', goods)
  }
}
