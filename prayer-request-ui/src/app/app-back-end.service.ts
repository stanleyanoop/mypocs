import { inject, Injectable, resource } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserData } from './model/user-model';
import { map, Observable, toArray } from 'rxjs';
import { WorklistData } from './model/worklist-model';

@Injectable({
  providedIn: 'root'
})
export class AppBackEndService {
  constructor() {}
  
  httpClient = inject(HttpClient)
  private apiDomain: string = "http://localhost:8081"

  getUser = (userName: string): Observable<UserData[]> => {
    let apiEndPoint = this.apiDomain + "/validuser/" + userName;
    let response: Observable<UserData[]> = this.httpClient.get<UserData[]>(apiEndPoint);
    return response;
  }

  getWorklistData = (userName: string): Observable<WorklistData[]> => {
    let apiEndPoint = this.apiDomain + "/worklist";
    let response: Observable<WorklistData[]> = this.httpClient.get<WorklistData[]>(apiEndPoint);
    return response;

  }
}



//   data =  new Observable<UserData[]>();
  
//   // user = signal<any>(null);
//   userDataList: UserData[] = [];

//   getUser1 = (userName: string): <UserData[]> => {
//     this.userName = userName;
//     let apiEndPoint = this.apiDomain + "/validuser/" + userName;
//     this.data = this.httpClient.get<any>(apiEndPoint);

//     return this.data;
//   }

  
// }

// export const getUser = resource(() => {
//   const http = inject(HttpClient);

//   return http.get<UserData[]>(apiEndPoint)
// });
