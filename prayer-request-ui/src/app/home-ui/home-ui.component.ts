import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { Observable } from 'rxjs';
import { WorklistData } from '../model/worklist-model';
import { Router } from '@angular/router';
import { AppHelper } from '../app.helper';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
@Component({
  selector: 'app-home-ui',
  imports: [MatTableModule, MatPaginatorModule],
  templateUrl: './home-ui.component.html',
  styleUrl: './home-ui.component.css'
})
export class HomeUiComponent implements OnInit, AfterViewInit {
  constructor(
    private route: Router,
    private helper: AppHelper
  ){}

  userName: string = "";
  homeTitle: string = "Prayer List Home Page";
  columnsToDisplay = ['reqId', 'reqFor', 'reqSubject', 'reqDate', 'resovedDate', 'reqStatus'];

  worklistObs: Observable<WorklistData[]> = new Observable<WorklistData[]>() ;
  workList: WorklistData[] = [];
  wlData = new MatTableDataSource<WorklistData>(this.workList);
  @ViewChild(MatPaginator)
  paginator: MatPaginator = new MatPaginator; 

  ngOnInit(): void {
    this.worklistObs = this.helper.getWorklistData(this.userName);
    this.worklistObs.subscribe((response) => {
      this.workList = response;
      this.wlData = new MatTableDataSource<WorklistData>(this.workList);

      console.log(this.workList);
    })
    // throw new Error('Method not implemented.');
  }
  ngAfterViewInit(): void {
    this.wlData.paginator = this.paginator;
    // throw new Error('Method not implemented.');
  }

}
