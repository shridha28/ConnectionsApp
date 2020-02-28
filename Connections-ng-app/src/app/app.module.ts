import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { LoginsignupComponent } from './loginsignup/loginsignup.component';
import {Router,Routes, RouterModule} from '@angular/router';
import { NotfoundComponent } from './notfound/notfound.component';
import {FormsModule} from '@angular/forms';
import { config } from 'rxjs';

const appRoutes:Routes=[
  {
    path:'loginsignup',
    component:LoginsignupComponent
  },
  {
    path:'feedback',
    component:FeedbackComponent
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
    NotfoundComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes,{enableTracing:true}),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
