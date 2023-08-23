import { Component, Input, OnInit } from '@angular/core';
import { Survey } from 'src/app/models/survey';

@Component({
  selector: 'app-survey-min',
  templateUrl: './survey-min.component.html',
  styleUrls: ['./survey-min.component.css'],
})
export class SurveyMinComponent implements OnInit {
  @Input() survey: Survey;
  surveyDetailsMap: any;

  ngOnInit() {
    this.surveyDetailsMap = new Map();
    this.surveyDetailsMap.set('Title', this.survey.title);
    this.surveyDetailsMap.set('Coordinator', this.survey.coordinatorUsername);
    this.surveyDetailsMap.set('Creation date', this.survey.creationDate);
    this.surveyDetailsMap.set('Timeframe', this.survey.timeframe);
  }
}
