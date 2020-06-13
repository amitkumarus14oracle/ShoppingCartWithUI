import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { Response } from '@angular/http/src/static_response';


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  _baseURL="/Shopping-cart-app/api/";
  constructor(private http: Http) { }

  // updateCart=function(id,quantity){
  //   this.http.post(this._baseURL+"productcart/"+id ,{"product_id":id,"quantity":quantity}).subscribe() ;
  // }

  cartDetails:any=[];
  productdetail
  total:number=0;

  getCartDetails=function(){

    this.http.get(this._baseURL+"productcart").subscribe((res: Response) => {
      let data = res.json();
      this.cartDetails= data; 
      
     this.total=0;
      for(var a of data){
        this.total+=a.price;
        
      }
      
    });
    

}

// getProductDetail = function (id) {
//   this.http.get(this._baseURL+"products/"+id).subscribe((res: Response) => {
//     let data = res.json();
//     this.details = data; 
//   })
// };

deleteCart(id){
  this.http.delete(this._baseURL+'productcart/'+id).subscribe((res: Response) => {
    this.getCartDetails();
  });
 
}

  ngOnInit() {
    this.getCartDetails()
  }

}
