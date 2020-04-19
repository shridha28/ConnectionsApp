import { Component, OnInit } from '@angular/core';

import {DataServiceService} from '../services-shared/data-service.service';
@Component({
  selector: 'app-activities',
  templateUrl: './activities.component.html',
  styleUrls: ['./activities.component.scss']
})
export class ActivitiesComponent implements OnInit {

  constructor(private transferService:DataServiceService) { }

  ngOnInit(): void {
    if(localStorage.getItem('currentUser'))
    this.transferService.isUserLoggedIn.next(true);
  }

}
