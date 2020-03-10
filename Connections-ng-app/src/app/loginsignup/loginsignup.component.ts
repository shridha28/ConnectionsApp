import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Router, ActivatedRoute} from '@angular/router';
import {DataServiceService} from '../services-shared/data-service.service';

@Component({
  selector: 'app-loginsignup',
  templateUrl: './loginsignup.component.html',
  styleUrls: ['./loginsignup.component.css']
})
export class LoginsignupComponent implements OnInit {

  signupModel:SignUpViewModel={
    username:'',
    password:'',
    emailid:''
  }
  
  loginModel:LoginViewModel={
    username:'',
    password:''
  }

  constructor(private http:HttpClient,
    private router:Router,private _route:ActivatedRoute,private transferService:DataServiceService) { 
        
      transferService.setData(this.signupModel.emailid);  
    }

  login():void{  
    let url = "http://localhost:8787/api/login";
    this.http.post(url,this.loginModel).subscribe(
     res =>  {
       this.router.navigateByUrl('/feedback');
     },
     err=> {alert("Sorry an error occured");
    });
  
  }

  signup():void{  
    let url = "http://localhost:8787/api/signup";
    this.http.post(url,this.signupModel).subscribe(
     res =>  {
       this.transferService.setData(this.signupModel.emailid);
      this.router.navigateByUrl('/editProfile');
     },
     err=> {alert("Sorry an error occured");
    });
  
  }

  ngOnInit(): void {
  } 

}

export interface SignUpViewModel{
  username:string,
  password:string,
  emailid:string
}


export interface LoginViewModel{
  username:string,
  password:string
}