import { Injectable } from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor,HttpRequest,HttpResponse,HttpErrorResponse} from '@angular/common/http';
import {Observable, of, throwError} from "rxjs";
import {catchError, map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class GlobalHttpInterceptorService implements HttpInterceptor {
intercept(request:HttpRequest<any>,next: HttpHandler): Observable<HttpEvent<any>>{
      return next.handle(request)
      .pipe(
         catchError((error: HttpErrorResponse) => {
            let errMsg = '';
            // Client Side Error
            if (error.error instanceof ErrorEvent) {
              errMsg = `Error: ${error.error.message}`;
              console.log('error is intercepted');
            }
            // Server Side Error
            else { 
              errMsg = `Error Code: ${error.status},  Message: ${error.message}`;
              console.log('error is intercepted');
            }
            console.log(errMsg);
            return throwError(errMsg);
          })
       )
}
  constructor() { }
}
