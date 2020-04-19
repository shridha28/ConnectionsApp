import { Component, OnInit,ChangeDetectorRef } from '@angular/core';
import {DataServiceService} from '../services-shared/data-service.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit{

  isUserLoggedIn: boolean;
  constructor(private dataSharingService: DataServiceService,
    private changeDetectorRef: ChangeDetectorRef,private router: Router) {
    
   }

  ngOnInit(): void {
    this.dataSharingService.isUserLoggedIn.subscribe( value => {
      this.isUserLoggedIn = value;
      this.changeDetectorRef.detectChanges();
    }); 
  }


  logout():void{
    localStorage.removeItem('currentUser');
    this.router.navigateByUrl('/loginsignup');
    this.isUserLoggedIn = false;

  }
}
