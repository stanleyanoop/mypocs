import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrayerReqUiComponent } from './prayer-req-ui.component';

describe('PrayerReqUiComponent', () => {
  let component: PrayerReqUiComponent;
  let fixture: ComponentFixture<PrayerReqUiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrayerReqUiComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrayerReqUiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
