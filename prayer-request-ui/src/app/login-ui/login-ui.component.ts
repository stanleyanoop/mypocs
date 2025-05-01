import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { NavigationExtras } from '@angular/router';
import { AppHelper } from '../app.helper';
import { Observable } from 'rxjs';
import { UserData } from '../model/user-model';

@Component({
  selector: 'app-login-ui',
  imports: [
    FormsModule
  ],
  templateUrl: './login-ui.component.html',
  styleUrl: './login-ui.component.css'
  // providers: [AppHelper]
})
export class LoginUiComponent {

  userNameLabel: string = "User Name : ";
  passwordLabel: string = "Password  : ";
  signInLabel: string = "Sign In";
  resetLabel: string = "Reset";
  userName: string = '';
  password: string  = '';
  isLabelVisible: boolean = false;
  data: Observable<UserData[]> = new Observable<UserData[]>() ;
   

  signIn(){
    console.log(this.userName);
    console.log(this.password);
    console.log(this.isLabelVisible);
    if (this.userName == '' || this.password == '') {
      this.isLabelVisible = true;
  } else {
    this.data = this.helper.isLoginSuccessful(this.userName, this.password);
    this.data.subscribe((response) => {
      console.log(response);
      response.forEach(obj => {
          console.log(obj.userName);
          console.log(obj.passWord);
          if (obj.userName === this.userName && obj.passWord === this.password) {
            this.route.navigate(['/home/']);
          } else {
            this.isLabelVisible = true;
          }
      });
  })

  }


    if (this.helper.isLoginSuccessful(this.userName, this.password)){
    } else {

    }
  }

  reset(){
    this.isLabelVisible =  false;
    this.userName = '';
    this.password = '';
  }

  constructor(
    private route: Router,
    private helper: AppHelper
  ){}

}
