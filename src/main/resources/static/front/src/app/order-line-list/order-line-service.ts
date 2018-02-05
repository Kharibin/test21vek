import {Observable} from "rxjs/Observable";
import {OrderLine} from "./orderLine";

export interface OrderLineService {

addNewOrderLine(orderLine :OrderLine) :Observable<OrderLine>;

deleteOrderLine(orderLine :OrderLine) :Observable<OrderLine>;

updateOrderLine(orderLine :OrderLine) :Observable<OrderLine>;

getOrderLineList(orderId: number):Observable<OrderLine[]>;

}
