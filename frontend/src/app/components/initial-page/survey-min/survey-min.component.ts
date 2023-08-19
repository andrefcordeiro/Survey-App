import { Component, Input } from '@angular/core';
import { Survey } from 'src/app/models/survey';

@Component({
  selector: 'app-survey-min',
  templateUrl: './survey-min.component.html',
  styleUrls: ['./survey-min.component.css'],
})
export class SurveyMinComponent {
  @Input() survey: Survey;
}
