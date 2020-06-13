import { Component, OnInit } from '@angular/core';
import { Http,Response } from '@angular/http';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  _baseURL="/Shopping-cart-app/api/";
  constructor(private http: Http) {
  }

 length:number=0;
 term;

  addToCart=function(name,photo,model,price){

            this.http.post(this._baseURL+"productcart" ,{"name":name,"photo":photo,"model":model,"price":price,"quantity":1}).subscribe() ;
            this.getCartDetails();
  }
  getCartDetails=function(){

    this.http.get(this._baseURL+"productcart").subscribe((res: Response) => {
      let data = res.json();
      this.length= data.length; 
    });
    
}
  

  
  details: any = [];
  getAllDetails = function () {
    this.http.get(this._baseURL+"products").subscribe((res: Response) => {
      let data = res.json();
      this.details = data; 
    })
  };
   filterDetails = function (value) {
    this.http.get(this._baseURL+"products").subscribe((res: Response) => {
      let data = res.json();
      this.details =data.filter(a=>a.category==value);
    
    })
  };
  ngOnInit() {
   
  this.getAllDetails();
  this.getCartDetails();

  }

}
