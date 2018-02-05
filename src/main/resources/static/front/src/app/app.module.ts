import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {TabViewModule} from 'primeng/tabview';
import {ButtonModule} from 'primeng/button';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HttpClientModule} from "@angular/common/http";
import {TableModule} from "primeng/components/table/table";
import {DialogModule} from 'primeng/dialog';
import {FormsModule} from "@angular/forms";
import {OrderListComponent} from './order-list/order-list.component';
import {OrderLineListComponent} from './order-line-list/order-line-list.component';
import {GoodsListComponent} from './goods-list/goods-list.component';
import {FrontServiceService} from "./front-service.service";


@NgModule({
  declarations: [
    AppComponent,
    GoodsListComponent,
    OrderListComponent,
    OrderLineListComponent
  ],
  imports: [
    BrowserModule,
    TabViewModule,
    ButtonModule,
    BrowserAnimationsModule,
    HttpClientModule,
    TableModule,
    DialogModule,
    FormsModule
  ],
  providers: [FrontServiceService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
