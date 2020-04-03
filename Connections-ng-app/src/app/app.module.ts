import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { LoginsignupComponent } from './loginsignup/loginsignup.component';
import {Router,Routes, RouterModule} from '@angular/router';
import { NotfoundComponent } from './notfound/notfound.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { config } from 'rxjs';
import {ForgotPasswordDialog} from '../app/loginsignup/forgotpassword.component';
import { EditprofileComponent } from './loginsignup/editprofile/editprofile.component';
import { MatDialogModule} from '@angular/material/dialog';
import { MatFormFieldModule} from '@angular/material/form-field';
import { MatButtonModule} from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {ConfirmEqualValidatorDirective} from './directives-shared/confirm-equal-validator.directive';
import { ActivitiesComponent } from './activities/activities.component';
import {AppRoutingModule} from './app-routing.module';
import {PasswordValidatorDirective} from './directives-shared/confirm-equal-validator.directive';



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
    path:'editProfile',
    component:EditprofileComponent,
    data: {animation: 'EditProfile'}
  },

  {
    path:'activities',
    component:ActivitiesComponent,
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
  declarations: [
    AppComponent,  
    NavigationComponent,
    FeedbackComponent,
    LoginsignupComponent,
    NotfoundComponent,
    ForgotPasswordDialog,
    EditprofileComponent,
    ConfirmEqualValidatorDirective,
    PasswordValidatorDirective
  ],
  imports: [
    MatButtonModule,
    MatDialogModule,
    MatInputModule,
    MatFormFieldModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  entryComponents: [ForgotPasswordDialog],
  bootstrap: [AppComponent]
})
export class AppModule { }
