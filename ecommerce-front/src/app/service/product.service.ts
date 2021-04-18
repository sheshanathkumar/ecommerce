import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Products } from '../model/products';
import { map } from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class ProductService{

  private url = "http://localhost:9090/api/product/all";
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
    return this.http.get <any> (this.url, this.options).pipe(
      map ( (res: HttpResponse<any>) => this.handleResponse(res))
    );
  }

  handleResponse(res: HttpResponse<any>): any {
    //console.log(res.status, res);
    return res;
  }

}
