import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductListComponent } from './component/product-list/product-list.component';
import { HttpClientModule } from '@angular/common/http'
import { ProductService } from './service/product.service';
import { FormsModule } from '@angular/forms';
import { ProductSingleComponent } from './component/product-single/product-single.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductSingleComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
