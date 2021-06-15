import { Component, OnInit } from '@angular/core';
import { Products } from 'src/app/model/products';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-product-list',
  //templateUrl: './product-list.component.html',
  templateUrl: './product-grid.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  prod1 : Products = {
    name: "JavaScript - The Fun Parts",
    price : 12.90,
    unit : 2,
    imgurl: "../assets/images/products/placeholder.png",
  }

  products : Products[] = [];
  
  constructor(private prodService : ProductService) { }

  ngOnInit(): void {

    console.log("hello");

    this.prodService.getProduct().subscribe(
      (data) => {
        //console.log(data);
        data.forEach(element => {
          this.products.push(element);
        });
        console.log(this.products);
      }) ;
    
  }

}
