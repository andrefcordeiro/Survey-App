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

  userRole: UserRole;
  roleTypes = UserRole;
  contentIsLoaded = false;

  ngOnInit() {
    this.userRole = this.userService.getUserRole();

    if (this.userRole === UserRole.COORDINATOR) {
      this.getSurveyStatistics();
    } else {
      this.getSurvey();
    }
  }

  private getSurvey() {
    this.surveyService.getSurvey(this.id).subscribe((res) => {
      this.survey = res as SurveyStatistics;
      this.contentIsLoaded = true;
    });
  }

  private getSurveyStatistics() {
    this.surveyService.getSurveyStatistics(this.id).subscribe((res) => {
      this.survey = res;
      this.contentIsLoaded = true;
    });
  }

  constructor(
    private surveyService: SurveyService,
    private userService: UserService
  ) {}
}
