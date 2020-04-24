import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { LoginsignupComponent } from './loginsignup/loginsignup.component';
import {Router,Routes, RouterModule} from '@angular/router';
import { NotfoundComponent } from './notfound/notfound.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule,HTTP_INTERCEPTORS} from '@angular/common/http';
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
import { ResetComponent } from './reset/reset.component';
import {LoginsignupService} from './loginsignup/loginsignup.service';
import { GlobalHttpInterceptorService} from './services-shared/global-http-interceptor.service';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomeComponent } from './homecomponent/home/home.component';

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
    PasswordValidatorDirective,
    ResetComponent,
    HomeComponent
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
    BrowserAnimationsModule,
    NgbModule
  ],
  providers: [LoginsignupService,{ provide: HTTP_INTERCEPTORS, useClass: GlobalHttpInterceptorService, multi: true  }],
  entryComponents: [ForgotPasswordDialog],
  bootstrap: [AppComponent]
})
export class AppModule { }
