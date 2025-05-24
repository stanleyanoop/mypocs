import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInput, MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatDatepickerModule, MatDatepickerToggle } from '@angular/material/datepicker';
import { ActivatedRoute } from '@angular/router';
import { AppHelper } from '../app.helper';
import { provideNativeDateAdapter } from '@angular/material/core';

@Component({
  selector: 'app-prayer-req-ui',
  providers: [provideNativeDateAdapter()],
  imports: [
    FormsModule, 
    MatFormFieldModule,
    MatInputModule,
    DatePipe,
    MatDatepickerModule,
    MatInput,
    MatDatepickerToggle,
    MatButtonModule, 
    MatIconModule
  ],
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './prayer-req-ui.component.html',
  styleUrl: './prayer-req-ui.component.css'
})
export class PrayerReqUiComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    private helper: AppHelper
  ) {}
  reqId!: number;
  name: string = '';
  requestTitle: string = '';
  requestedDate: string = '';
  resolvedDate: string = '';
  otherDetails: string = '';
  isNewReq: boolean = true;
  ngOnInit(): void {
    // this.route.params
    this.route.params.subscribe(param => {
      this.reqId = param['id'];
      console.log("reqId got from the home page ===> " + this.reqId);
    })
    console.log("reqId got from the home page ===> " + this.reqId);
    if (this.reqId){
      this.isNewReq = false;
      let response = this.helper.getRequestDetails(this.reqId)
      response.subscribe(data => {
        console.log(data.dateRequested);
        this.reqId = data.worklistId;
        this.name = data.name;
        this.requestTitle = data.shortRequest;
        this.requestedDate = data.dateRequested;
        this.resolvedDate = data.dateResolved;  
      })
    }else {

    }
  }

  deleteRequest(){
    console.log("Delete request with id ===> " + this.reqId);
    
  }

}
