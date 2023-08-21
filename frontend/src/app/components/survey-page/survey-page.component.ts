import { Component, Input } from '@angular/core';
import { UserRole } from 'src/app/models/enums/user-role';
import { SurveyResponse } from 'src/app/models/survey-response';
import { SurveyResponseService } from 'src/app/service/survey-response.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-survey-page',
  templateUrl: './survey-page.component.html',
  styleUrls: ['./survey-page.component.css'],
  providers: [SurveyResponseService, UserService],
})
export class SurveyPageComponent {
  @Input() id: Number;
  surveyResponse: SurveyResponse;
  surveyDetailsMap: any;
  userRole: UserRole;

  ngOnInit() {
    this.userRole = this.userService.getUserRole();
    this.surveyResponseService
      .getSurvey(this.id, this.userRole)
      .subscribe((res) => {
        this.surveyResponse = res;

        console.log(this.surveyResponse);

        this.surveyDetailsMap.set(
          'Coordinator',
          this.surveyResponse.coordinatorUsername
        );
        this.surveyDetailsMap.set(
          'Creation date',
          this.surveyResponse.creationDate
        );
        this.surveyDetailsMap.set('Timeframe', this.surveyResponse.timeframe);
      });
  }

  constructor(
    private surveyResponseService: SurveyResponseService,
    private userService: UserService
  ) {
    this.surveyDetailsMap = new Map();
  }
}
