import { Observable } from "rxjs";
import { AppBackEndService } from "./app-back-end.service";
import { UserData } from "./model/user-model";
import { Injectable, signal } from "@angular/core";

@Injectable({
    providedIn: 'root'
  })
export class AppHelper {

    constructor(
        private service: AppBackEndService
    ) {}
    // data = signal<any>(null);
    private data: Observable<UserData[]> = new Observable<UserData[]>() ;
    private user: UserData[] = [];
    isLoginSuccessful = (userName: string, password: string): Observable<UserData[]>  => {
        console.log ("Inside the AppHelper.isLoginSuccessful method: name -" + userName)
        let response: Observable<UserData[]> = new Observable<UserData[]>;
        response = this.service.getUser(userName)
        return response;
    }
}

function next(value: UserData): void {
    throw new Error("Function not implemented.");
}
