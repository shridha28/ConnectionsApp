import { Injectable } from '@angular/core';

import {Router} from '@angular/router';
import { SignUpViewModel } from './loginsignup/loginsignup.component';
import {BehaviorSubject} from 'rxjs';


@Injectable({
    providedIn:'root'
})
export class TransferService {
signUPModel:SignUpViewModel;
  bhvrSubject : BehaviorSubject<SignUpViewModel>;
  currentValue:any;
  constructor(
    private router:Router) { 
        this.bhvrSubject = new BehaviorSubject(this.signUPModel);
       this.currentValue = this.bhvrSubject.asObservable;
    }

  private data:string;

  setData(data){
    this.data = data;
  }

  getData(){
    let temp = this.data;
    this.clearData();
    return temp;
  }

  clearData(){
    this.data = undefined;
  }
}