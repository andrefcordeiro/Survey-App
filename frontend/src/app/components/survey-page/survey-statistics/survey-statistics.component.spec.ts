import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SurveyStatisticsComponent } from './survey-statistics.component';

describe('SurveyStatisticsComponent', () => {
  let component: SurveyStatisticsComponent;
  let fixture: ComponentFixture<SurveyStatisticsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SurveyStatisticsComponent]
    });
    fixture = TestBed.createComponent(SurveyStatisticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
