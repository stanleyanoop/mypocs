import { AfterViewInit, Component, inject, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { Observable } from 'rxjs';
import { WorklistData } from '../model/worklist-model';
import { Router } from '@angular/router';
import { AppHelper } from '../app.helper';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import {MatSort, Sort, MatSortModule} from '@angular/material/sort';
import { LiveAnnouncer } from '@angular/cdk/a11y';

@Component({
  selector: 'app-home-ui',
  imports: [
    MatTableModule, 
    MatPaginatorModule, 
    MatSortModule
  ],
  templateUrl: './home-ui.component.html',
  styleUrl: './home-ui.component.css'
})
export class HomeUiComponent implements OnInit, AfterViewInit {
  private _liveAnnouncer = inject(LiveAnnouncer);
  constructor(
    private route: Router,
    private helper: AppHelper
  ){}

  userName: string = "";
  homeTitle: string = "Prayer List Home Page";
  columnsToDisplay = ['worklistId', 'name', 'shortRequest', 'dateRequested', 'dateResolved', 'requestStatus.status'];
  size: number = 0;

  worklistObs: Observable<WorklistData[]> = new Observable<WorklistData[]>() ;
  workList: WorklistData[] = [];
  wlData = new MatTableDataSource<WorklistData>();
  @ViewChild(MatPaginator)
  paginator: MatPaginator = new MatPaginator;
  @ViewChild(MatSort)
  sort: MatSort = new MatSort;

  ngOnInit(): void {
    this.worklistObs = this.helper.getWorklistData(this.userName);
    this.worklistObs.subscribe((response) => {
      this.workList = response;
      this.wlData.data = response;//new MatTableDataSource<WorklistData>(this.workList);
      this.size = this.workList.length;
      console.log("Number of records : " + this.size)
      console.log(this.workList);
    })
    // throw new Error('Method not implemented.');
  }
  ngAfterViewInit(): void {
    this.wlData.sortingDataAccessor = (item, property) => {
      switch(property) {
        case 'requestStatus.status': return item.requestStatus.status;
        default: return item[property];
      }
    };
    this.wlData.sort = this.sort;
    this.wlData.paginator = this.paginator;

    // throw new Error('Method not implemented.');
  }

  announceSortChange(sortState: Sort) {
    // This example uses English messages. If your application supports
    // multiple language, you would internationalize these strings.
    // Furthermore, you can customize the message to add additional
    // details about the values being sorted.
    if (sortState.direction) {
      this._liveAnnouncer.announce(`Sorted ${sortState.direction} ending`);
    } else {
      this._liveAnnouncer.announce('Sorting cleared');
    }
  }
}
