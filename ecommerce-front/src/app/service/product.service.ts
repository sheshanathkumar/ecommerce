import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Products } from '../model/products';
import { map } from 'rxjs/operators'
import { environment } from 'src/environments/environment';
import { ApiConstants } from '../utills/ApiConstants';

@Injectable({
  providedIn: 'root'
})
export class ProductService{

  private apiUrl: string = environment.api_url;
  private allProduct :string = ApiConstants.getAllProducts;
  prods : Products[] = [];

  headers = new HttpHeaders( {
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin' : '*',
    'Access-Control-Allow-Methods': 'GET,POST,OPTIONS,DELETE,PUT'
  });

  options = { headers: this.headers };

  constructor(private http : HttpClient) { }

  getProduct() {
    console.log("Hello from product service");
    return this.http.get <any> ( this.apiUrl+this.allProduct  , this.options).pipe(
      map ( (res: HttpResponse<any>) => this.handleResponse(res))
    );
  }

  handleResponse(res: HttpResponse<any>): any {
    //console.log(res.status, res);
    return res;
  }

}
