import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { Response } from '@angular/http/src/static_response';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  _baseURL="/Shopping-cart-app/api/";

  userDetails:any={
    name:'',
    address:'',
    city:'',
    state:'',
    country:'',
    pincode:'',
    contact:''

  };

  message=false


  constructor(private http:Http) { }

  addDetails(userDetails){
    let headers = new Headers({ 'Content-Type': 'application/json' });
    
  
    this.http.post(this._baseURL+'customer/',{"name":userDetails.name,
    "address":userDetails.address,
    "city":userDetails.city,
    "state":userDetails.state,
    "country":userDetails.country
  ,"pincode":userDetails.pincode,"contact":userDetails.contact}).subscribe((res:Response)=>{
    this.userDetails={
      name:'',
      address:'',
      city:'',
      state:'',
      country:'',
      pincode:'',
      contact:''
  


    };
    this.message=true;
      
  })
};
  ngOnInit() {
  }

}
