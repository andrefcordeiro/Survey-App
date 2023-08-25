import { Component, Input, OnInit } from '@angular/core';
import { UserRole } from 'src/app/models/enums/user-role';
import { SurveyStatistics } from 'src/app/models/survey-statistics';
import { SurveyService } from 'src/app/service/survey.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-survey-page',
  templateUrl: './survey-page.component.html',
  styleUrls: ['./survey-page.component.css'],
  providers: [SurveyService, UserService],
})
export class SurveyPageComponent implements OnInit {
  @Input() id: Number;

  survey: SurveyStatistics;
  surveyIsFinished: boolean = false;

  userRole: UserRole;
  roleTypes = UserRole;
  contentIsLoaded = false;

  ngOnInit() {
    this.userRole = this.userService.getUserRole();

    this.getSurvey();
  }

  private getSurvey() {
    this.surveyService.getSurveyStatistics(this.id).subscribe((res) => {
      this.survey = res;
      this.contentIsLoaded = true;

      this.checkIfSurveyIsFinished(this.survey.timeframe!);
    });
  }

  private checkIfSurveyIsFinished(timeframe: Date): boolean {
    const timeframeDate = new Date(timeframe);
    timeframeDate.setHours(0, 0, 0, 0);

    const today = new Date();
    today.setHours(0, 0, 0, 0);

    if (timeframeDate < today) {
      this.surveyIsFinished = true;
      return true;
    }

    return false;
  }

  constructor(
    private surveyService: SurveyService,
    private userService: UserService
  ) {}
}
