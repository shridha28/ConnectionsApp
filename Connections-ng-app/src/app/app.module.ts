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
import { EditprofileComponent } from './loginsignup/editprofile/editprofile.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {ConfirmEqualValidatorDirective} from './directives-shared/confirm-equal-validator.directive';

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
    EditprofileComponent,
    ConfirmEqualValidatorDirective
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes,{enableTracing:true}),
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
