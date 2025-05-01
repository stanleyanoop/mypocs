import { Observable } from "rxjs";
import { AppBackEndService } from "./app-back-end.service";
import { UserData } from "./model/user-model";
import { Injectable, signal } from "@angular/core";
import { WorklistData } from "./model/worklist-model";

@Injectable({
    providedIn: 'root'
  })
export class AppHelper {
    constructor(
        private service: AppBackEndService
    ) {}

    getWorklistData = (userName: string): Observable<WorklistData[]> => {
        console.log ("Inside the AppHelper.getWorklistData method: name -" + userName);
        let response: Observable<WorklistData[]> = new Observable<WorklistData[]>;
        response = this.service.getWorklistData(userName)
        return response;
    }

    isLoginSuccessful = (userName: string, password: string): Observable<UserData[]>  => {
        console.log ("Inside the AppHelper.isLoginSuccessful method: name -" + userName);
        let response: Observable<UserData[]> = new Observable<UserData[]>;
        response = this.service.getUser(userName)
        return response;
    }
}

function next(value: UserData): void {
    throw new Error("Function not implemented.");
}
