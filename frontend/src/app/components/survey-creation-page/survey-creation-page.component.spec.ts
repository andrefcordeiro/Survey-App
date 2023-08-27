import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SurveyCreationPageComponent } from './survey-creation-page.component';

describe('SurveyCreationPageComponent', () => {
  let component: SurveyCreationPageComponent;
  let fixture: ComponentFixture<SurveyCreationPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SurveyCreationPageComponent]
    });
    fixture = TestBed.createComponent(SurveyCreationPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
