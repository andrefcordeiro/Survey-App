import { Component, Input } from '@angular/core';
import { QuestionStatistics } from 'src/app/models/question-statistics';
import { SurveyStatistics } from 'src/app/models/survey-statistics';

@Component({
  selector: 'app-survey-statistics',
  templateUrl: './survey-statistics.component.html',
  styleUrls: ['./survey-statistics.component.css'],
})
export class SurveyStatisticsComponent {
  @Input() surveyStatistics: SurveyStatistics;

  ngOnInit() {}

  getOptionsNums(qStats: QuestionStatistics): any[] {
    let optionsNums: any[] = [];

    qStats.optionSelectionCounts.forEach((e) =>
      optionsNums.push(e.optionNumber)
    );

    return optionsNums;
  }

  getNumberOfSelections(qStats: QuestionStatistics) {
    let numberOfSelections: any[] = [];

    qStats.optionSelectionCounts.forEach((e) =>
      numberOfSelections.push(e.numberOfSelections)
    );

    return numberOfSelections;
  }
}
