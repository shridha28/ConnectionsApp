import { Component, OnInit, Input } from '@angular/core';
import { SignUpViewModel } from '../loginsignup.component';
import {DataServiceService} from '../../services-shared/data-service.service';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.css']
})
export class EditprofileComponent implements OnInit {

  email_Id:string;
  response:any;
  state:string;
  cities:any;

  eProfileModel:EditProfileModel={
    emailid:'',
    name:'',
    street:'',
    landmark:'',
    houseNumber:'',
    city:'',
    state:''
  };

   viewModel:SignUpViewModel;

  constructor(private transferService:DataServiceService,private http:HttpClient,
    private router: Router){
    this.email_Id = transferService.getData();
  }
  
  ngOnInit(): void {
   // alert('hithere');
    let url = "http://localhost:8787/getStatesData";
    this.http.get(url).subscribe(
     res =>  {
     this.response =  JSON.parse(JSON.stringify(res));
     },
     err=> {alert("Sorry an error occured");
    });
  }

 populateCities():void{
   //alert(this.state);
   let url = "http://localhost:8787/getStatesData/"+this.state;
    this.http.get(url).subscribe(
     res =>  {
     this.cities =  JSON.parse(JSON.stringify(res));
     },
     err=> {alert("Sorry an error occured");
    });
 }
  
}


export interface EditProfileModel{
  emailid:string,
  street:string,
  landmark:string,
  houseNumber:string,
  city:string,
  state:string,
  name:string

}