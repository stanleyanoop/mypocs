import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

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

  signIn(){
    this.isLabelVisible = true;
    console.log(this.userName);
    console.log(this.password);
    console.log(this.isLabelVisible);
  }

  reset(){
    this.isLabelVisible =  false;
    this.userName = '';
    this.password = '';
  }

}
