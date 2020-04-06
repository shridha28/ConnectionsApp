import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FeedbackComponent } from './feedback/feedback.component';
import { LoginsignupComponent } from './loginsignup/loginsignup.component';
import {Router,Routes, RouterModule} from '@angular/router';
import { NotfoundComponent } from './notfound/notfound.component';
import { EditprofileComponent } from './loginsignup/editprofile/editprofile.component';
import { ActivitiesComponent } from './activities/activities.component';
import { MatDialogModule} from '@angular/material/dialog';
import { MatFormFieldModule} from '@angular/material/form-field';
import { MatButtonModule} from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';



const appRoutes:Routes=[
  {
    path:'loginsignup',
    component:LoginsignupComponent,
    data: {animation: 'LoginSingUp'}
  },
  {
    path:'feedback',
    component:FeedbackComponent,
    data: {animation: 'Feedback'}
  },

  {
    path:'activities',
    component:ActivitiesComponent,
    data: {animation: 'Feedback'}
  },

  {
    path:'editProfile',
    component:EditprofileComponent,
    data: {animation: 'EditProfile'}
  },
  {
    path:'',
    component:LoginsignupComponent,
    pathMatch:'full'
  },
  {
    path:'**',
    component:NotfoundComponent
  },

  
];
@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(appRoutes),
    MatButtonModule,
    MatDialogModule,
    MatInputModule,
    MatFormFieldModule
  ],
  exports:[RouterModule]
})
export class AppRoutingModule { }
