import { Component, OnInit, Input } from '@angular/core';
import { SignUpViewModel } from '../loginsignup.component';
import {DataServiceService} from '../../services-shared/data-service.service';
@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.css']
})
export class EditprofileComponent implements OnInit {

  email_Id:string;

   viewModel:SignUpViewModel;

  constructor(private transferService:DataServiceService){
    this.email_Id = transferService.getData();
    //alert(transferService.getData()); 
  }
  
  ngOnInit(): void {
    

  }
  
}
