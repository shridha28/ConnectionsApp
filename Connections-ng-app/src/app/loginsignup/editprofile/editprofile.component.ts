import { Component, OnInit, Input } from '@angular/core';
import { SignUpViewModel } from '../loginsignup.component';
import {DataServiceService} from '../../services-shared/data-service.service';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.scss']
})
export class EditprofileComponent implements OnInit {

  email_Id:string;
  response:any;
  arrays:object[];
  stateCities:Object[];
  state:string;
  cities:any;


  eProfileModel:EditProfileModel={
    emailid:'',
    name:'',
    street:'',
    landMark:'',
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
    let url = "http://localhost:8787/getStatesData";
    this.http.get(url).subscribe(
     res =>  {
     this.response =  JSON.parse(JSON.stringify(res));
     },
     err=> {alert("Sorry an error occured");
    });
  }

 populateCities():void{
   let url = "http://localhost:8787/getStatesData/"+this.state;
    this.http.get(url).subscribe(
     res =>  {
     this.cities =  JSON.parse(JSON.stringify(res));
     },
     err=> {alert("Sorry an error occured");
    });
 }

 submit():void{
   this.eProfileModel.state = this.response[this.state].stateName;
   this.eProfileModel.emailid = this.email_Id;
   let url = "http://localhost:8787/api/updateProfile";
   this.http.patch(url,this.eProfileModel).subscribe(
    res =>  {
     alert("Profile Updated Successfully");
     this.router.navigateByUrl('/activities');
    },
    err=> {alert("Sorry an error occured");
   });
 }
  
}


export interface EditProfileModel{
  emailid:string,
  street:string,
  landMark:string,
  houseNumber:string,
  city:string,
  state:string,
  name:string

}
