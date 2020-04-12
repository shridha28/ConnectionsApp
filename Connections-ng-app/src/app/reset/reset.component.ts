    /*
    @author=Shreya Jalihal;
    */

    import { Component, OnInit,ChangeDetectorRef } from '@angular/core';
    import { HttpClient,HttpHeaders, HttpParams } from '@angular/common/http';
    import {Router, ActivatedRoute} from '@angular/router';
    import {DataServiceService} from '../services-shared/data-service.service';


    @Component({
      selector: 'app-reset',
      templateUrl: './reset.component.html',
      styleUrls: ['./reset.component.css']
    })
    export class ResetComponent implements OnInit {
      response:any;
      isHidden: boolean = true;
      code:any;
      emailid:string;
      message:string;


      resetPassword:ResetPassword={
        code:'',
        password:'',
        emailid:''
      }

      constructor(private transferService:DataServiceService,private http:HttpClient,
        private router: Router){
          this.emailid = transferService.getData();
        }

        ngOnInit():void {
        }

        //function call to verify the code sent to the customer's email and display form for generating new possword
        verifyCode():void{
          let params = new HttpParams();
          params = params.append('code', this.code);
          params = params.append('emailId', this.emailid);
          let url="http://localhost:8787/resetform";
          this.http.get(url,{params:params}).subscribe(
            res =>  {
              this.response = JSON.parse(JSON.stringify(res));
              if(this.response.error==null || this.response.error=="")
                 this.isHidden = false;
              else
                 this.message=this.response.error;
            },
            err=> {alert("Sorry an error occured");
          });
        }
        //function call to save the new password of the customer to the database.
        saveNewPassword():void{
          this.resetPassword.code=this.code;
          this.resetPassword.emailid=this.emailid;
          console.log(this.resetPassword);

          let url = "http://localhost:8787/reset";
          this.http.post(url,this.resetPassword).subscribe(
            res =>  {
              this.response = JSON.parse(JSON.stringify(res));
              if(this.response.error==null || this.response.error=="")
                alert("Your password has been changed successfully");
                this.router.navigateByUrl('/loginsignup');
            },
            err=> {alert("Sorry an error occured");
          });
        }
      }

      export interface ResetPassword{
        code:any,
        password:string,
        emailid:string
      }
