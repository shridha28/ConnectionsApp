import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  public isUserLoggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  private data:string;

  setData(value) {
    this.data = value;
  }  

  getData() {
    return this.data;
  }

  constructor() { }
}
