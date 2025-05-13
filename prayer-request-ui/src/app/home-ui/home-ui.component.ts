import { AfterViewInit, Component, inject, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { Observable } from 'rxjs';
import { WorklistData } from '../model/worklist-model';
import { Router, RouterModule, ActivatedRoute } from '@angular/router';
import { AppHelper } from '../app.helper';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import {MatSort, MatSortModule} from '@angular/material/sort';
import { W } from '@angular/cdk/keycodes';

@Component({
  selector: 'app-home-ui',
  imports: [
    MatTableModule, 
    MatPaginatorModule, 
    MatSortModule,
    RouterModule
  ],
  templateUrl: './home-ui.component.html',
  styleUrl: './home-ui.component.css'
})
export class HomeUiComponent implements OnInit, AfterViewInit {
  private  activatedRoute = inject(ActivatedRoute);
  constructor(
    private route: Router,
    private helper: AppHelper
  ){}

  userName: string = "";
  homeTitle: string = "Prayer List Home Page";
  columnsToDisplay = ['worklistId', 'name', 'shortRequest', 'dateRequested', 'dateResolved', 'requestStatus.status'];
  size: number = 0;
  showDiv: string = "no-show";

  worklistObs: Observable<WorklistData[]> = new Observable<WorklistData[]>() ;
  workList: WorklistData[] = [];
  wlData = new MatTableDataSource<WorklistData>();
  @ViewChild(MatPaginator)
  paginator: MatPaginator = new MatPaginator;
  @ViewChild(MatSort)
  sort: MatSort = new MatSort;

  navigateToDetails(wlId: string): void {
    console.log("Navigating to the details page for ID ::" + wlId)
    // this.route.navigate(["home/prayerRequest/", wlId, "/"])
  }
  ngOnInit(): void {
    this.showDiv = "show-div"
    this.worklistObs = this.helper.getWorklistData(this.userName);
    this.worklistObs.subscribe((response) => {
      this.workList = response;
      this.wlData.data = response;//new MatTableDataSource<WorklistData>(this.workList);
      this.size = this.workList.length;
      console.log("Number of records : " + this.size)
      console.log(this.workList);
    })
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
  }
}
