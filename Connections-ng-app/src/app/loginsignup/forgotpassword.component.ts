import { Component, OnInit, Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Router, ActivatedRoute} from '@angular/router';
import {DataServiceService} from '../services-shared/data-service.service';
import {MatDialog,MAT_DIALOG_DATA,MatDialogRef} from '@angular/material/dialog';


@Component({
  
    selector: 'forgotcomponentdialog',
    templateUrl: 'forgotpassword.component.html',
    styleUrls: ['forgotpassword.component.css']
  })
  export class ForgotPasswordDialog {

    message:string;
  
    constructor(
      public dialogRef: MatDialogRef<ForgotPasswordDialog>,
      @Inject(MAT_DIALOG_DATA) public data: DialogData,private http:HttpClient) {}
  
    onNoClick(): void {
      this.dialogRef.close();
    }
    
    onClick():void{
     this.message="Mail Sent! Please check your email inbox";
     let url = "http://localhost:8787/api/sendemail/"+this.data.emailid;
     
     this.http.get(url).subscribe(
      res =>  {
      },
      err=> {alert("Sorry an error occured");
     });
    }
  }

  export interface DialogData {
    emailid: string;
  }