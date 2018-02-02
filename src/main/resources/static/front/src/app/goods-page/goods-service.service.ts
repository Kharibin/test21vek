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
}
