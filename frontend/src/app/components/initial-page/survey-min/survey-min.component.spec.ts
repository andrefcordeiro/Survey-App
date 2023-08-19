import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SurveyMinComponent } from './survey-min.component';

describe('SurveyMinComponent', () => {
  let component: SurveyMinComponent;
  let fixture: ComponentFixture<SurveyMinComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SurveyMinComponent]
    });
    fixture = TestBed.createComponent(SurveyMinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
