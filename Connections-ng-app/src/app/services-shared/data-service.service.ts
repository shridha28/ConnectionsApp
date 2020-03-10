import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  private data:string;

  setData(value) {      
    this.data = value;  
  }  
  
  getData() {  
    return this.data;  
  }

  constructor() { }
}
