import { Injectable } from '@angular/core';
import {OrderLine} from "./orderLine";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class OrderLineServiceService {

  constructor(private httpClient: HttpClient) { }

  getOrderLines(): Observable<OrderLine[]>{
    return this.httpClient.get<OrderLine[]>('localhost:8080/allOrderLines');
  }

  addOrderLine(){

  }

  ngOnInit(){
    this.getOrderLines();
  }
}
