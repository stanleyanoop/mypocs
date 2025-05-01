import { Component, OnInit } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { Observable } from 'rxjs';
import { WorklistData } from '../model/worklist-model';
import { Router } from '@angular/router';
import { AppHelper } from '../app.helper';
@Component({
  selector: 'app-home-ui',
  imports: [MatTableModule],
  templateUrl: './home-ui.component.html',
  styleUrl: './home-ui.component.css'
})
export class HomeUiComponent implements OnInit {
  constructor(
    private route: Router,
    private helper: AppHelper
  ){}

  userName: string = "";
  homeTitle: string = "Prayer List Home Page";
  wlData: Observable<WorklistData[]> = new Observable<WorklistData[]>() ;
  columnsToDisplay = ['reqId', 'reqFor', 'reqSubject', 'reqDate', 'resovedDate', 'reqStatus'];

  ngOnInit(): void {
    this.wlData = this.helper.getWorklistData(this.userName);
    // throw new Error('Method not implemented.');
  }

}
