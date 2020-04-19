import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {DataServiceService} from '../services-shared/data-service.service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.scss']
})
export class FeedbackComponent implements OnInit {
  model:FeedbackViewModel = {
    name:'',
    email:'',
    feedback:''
  };
  constructor(private http:HttpClient,private transferService:DataServiceService) {

   }
  ngOnInit(): void { 
    if(localStorage.getItem('currentUser'))
    this.transferService.isUserLoggedIn.next(true);
  }

  sendFeedback():void{
    //alert(this.model.name);
    let url = "http://localhost:8787/api/feedback";
    this.http.post(url,this.model).subscribe(
     res =>  {
       location.reload();
     },
     err=> {alert("Sorry an error occured");
    });
  }
}
export interface FeedbackViewModel{
    name:string;
    email:string;
    feedback:string;
}