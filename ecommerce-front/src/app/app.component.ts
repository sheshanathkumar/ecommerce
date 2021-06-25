import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'ecommerce-front';

  constructor(private router: Router) { }
  ngOnInit(): void {

    console.log("in local");
    //this.router.navigate(['/product'])

  }


}

