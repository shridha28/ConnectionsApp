import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';


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

  constructor(private http:HttpClient) { }

  login():void{  
    let url = "http://localhost:8787/api/login";
    this.http.post(url,this.loginModel).subscribe(
     res =>  {
       location.reload();
     },
     err=> {alert("Sorry an error occured");
    });
  
  }

  signup():void{  
    let url = "http://localhost:8787/api/signup";
    this.http.post(url,this.signupModel).subscribe(
     res =>  {
       location.reload();
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