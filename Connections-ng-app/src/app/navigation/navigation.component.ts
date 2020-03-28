import { Component, OnInit,ChangeDetectorRef } from '@angular/core';
import {DataServiceService} from '../services-shared/data-service.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit{

  isUserLoggedIn: boolean;
  constructor(private dataSharingService: DataServiceService,
    private changeDetectorRef: ChangeDetectorRef) {
    
   }

  ngOnInit(): void {
    this.dataSharingService.isUserLoggedIn.subscribe( value => {
      this.isUserLoggedIn = value;
      this.changeDetectorRef.detectChanges();
    }); 
  }

}
