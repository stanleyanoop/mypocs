import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

import { AppHelper } from '../app.helper';

@Component({
  selector: 'app-login-ui',
  imports: [
    FormsModule
  ],
  templateUrl: './login-ui.component.html',
  styleUrl: './login-ui.component.css'
})
export class LoginUiComponent {

  userNameLabel: string = "User Name : ";
  passwordLabel: string = "Password  : ";
  signInLabel: string = "Sign In";
  resetLabel: string = "Reset";
  userName: string = '';
  password: string  = '';
  isLabelVisible: boolean = false;
  helper: AppHelper = new AppHelper(); 

  signIn(){
    console.log(this.userName);
    console.log(this.password);
    console.log(this.isLabelVisible);
    if (this.helper.isLoginSuccessful(this.userName, this.password)){
      this.route.navigate(['/home']);
    } else {
      this.isLabelVisible = true;

    }
  }

  reset(){
    this.isLabelVisible =  false;
    this.userName = '';
    this.password = '';
  }

  constructor(private route: Router){}

}
