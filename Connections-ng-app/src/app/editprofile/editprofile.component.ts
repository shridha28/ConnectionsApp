import { Component, OnInit } from '@angular/core';
import {TransferService} from '../app.transferservice';
import { SignUpViewModel } from '../loginsignup/loginsignup.component';

@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.css']
})
export class EditprofileComponent implements OnInit {

  private data : ()=>string;
  // = this.transfereService.getData;

  constructor( private transfereService:TransferService) { 
  this.data =  this.transfereService.getData;
  alert(this.data.apply.name);
  }

  ngOnInit(): void {
  }

}
