import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';


import {TabViewModule} from 'primeng/primeng';
import {ButtonModule} from 'primeng/button';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { AllordersComponent } from './allorders/allorders.component';
import { OrderLineAddFormComponent } from './order-line-add-form/order-line-add-form.component';
import { OrderLineListComponent } from './order-line-list/order-line-list.component';
import { OrderLinePageComponent } from './order-line-page/order-line-page.component';
import { GoodsPageComponent } from './goods-page/goods-page.component';
import { GoodsAddFormComponent } from './goods-page/goods-add-form/goods-add-form.component';
import { GoodsListComponent } from './goods-page/goods-list/goods-list.component';
import {HttpClientModule} from "@angular/common/http";
import {GoodsServiceService} from "./goods-page/goods-service.service";
import {TableModule} from "primeng/components/table/table";
import { GoodsEditFormComponent } from './goods-page/goods-edit-form/goods-edit-form.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AllordersComponent,
    OrderLineAddFormComponent,
    OrderLineListComponent,
    OrderLinePageComponent,
    GoodsPageComponent,
    GoodsAddFormComponent,
    GoodsListComponent,
    GoodsEditFormComponent
  ],
  imports: [
    BrowserModule,
    TabViewModule,
    ButtonModule,
    BrowserAnimationsModule,
    HttpClientModule,
    TableModule
  ],
  providers: [GoodsServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
