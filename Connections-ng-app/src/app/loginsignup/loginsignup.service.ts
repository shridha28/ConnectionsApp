import { Injectable } from '@angular/core';
import { Component, OnInit, Inject } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import {Router, ActivatedRoute} from '@angular/router';
import {DataServiceService} from '../services-shared/data-service.service';
import {MatDialog,MAT_DIALOG_DATA,MatDialogRef} from '@angular/material/dialog';
import {ForgotPasswordDialog} from './forgotpassword.component';
import { Observable } from 'rxjs';
import{environment} from '../../environments/environment';
@Injectable({
  providedIn: 'root'
})
export class LoginsignupService {

response:any;

  constructor(private http:HttpClient) { }



  loginCustomer(data):void{
    let url = `${environment.Url}/api/signup`;
    const headers = new HttpHeaders(data? {
      authorization : 'Basic ' + btoa(data.emailId + ':' + data.password)
  } : {});

  this.http.get(url, {headers: headers}).subscribe(response => {
      if (response) {
        console.log('response sent');
      } else {
        console.log('response not sent');
      }
  });
 
  }


  
  signupCustomer(data):Observable<any>{  
    let url = `${environment.Url}/api/signup`;
   return this.http.post<any>(url,data);
  }


}
