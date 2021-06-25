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
  private categoryProduct : string = ApiConstants.productByCategory;
  private categories : string = ApiConstants.allCategories;
  private searchProduct : string = ApiConstants.findProduct;
  prods : Products[] = [];

  headers = new HttpHeaders( {
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin' : '*',
    'Access-Control-Allow-Methods': 'GET,POST,OPTIONS,DELETE,PUT'
  });

  options = { headers: this.headers };

  constructor(private http : HttpClient) { }

  getProduct() {
    console.log("getting all product");
    return this.http.get <any> ( this.apiUrl+this.allProduct  , this.options).pipe(
      map ( (res: HttpResponse<any>) => this.handleResponse(res))
    );
  }


  getProductByCategories (category: string) {
    console.log(`${this.apiUrl}${this.categoryProduct}?category=${category}`);
    return this.http.get<any>(`${this.apiUrl}${this.categoryProduct}?category=${category}`, this.options).pipe(
      map ( (res: HttpResponse<any>) => this.handleResponse(res))
    )
  }

  findProduct (search : string) {
    console.log (`${this.apiUrl}{this.searchProduct}??search=${search}`);
    return this.http.get<any>(`${this.apiUrl}${this.searchProduct}?search=${search}`, this.options).pipe(
      map( (res: HttpResponse<any>) => this.handleResponse(res))
    )
  }

  handleResponse(res: HttpResponse<any>): any {
    console.log(res.status, res);
    return res;
  }

}
