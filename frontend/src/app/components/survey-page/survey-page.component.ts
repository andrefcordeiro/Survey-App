import { Component, Input, OnInit } from '@angular/core';
import { UserRole } from 'src/app/models/enums/user-role';
import { Survey } from 'src/app/models/survey';
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
  surveyStatistics: Survey;
  userRole: UserRole;
  roleTypes = UserRole;
  contentIsLoaded = false;

  ngOnInit() {
    this.userRole = this.userService.getUserRole();

    if (this.userRole === UserRole.COORDINATOR) {
      this.getSurveyStatistics();
    }
  }

  private getSurveyStatistics() {
    this.surveyService.getSurveyStatistics(this.id).subscribe((res) => {
      this.surveyStatistics = res;
      this.contentIsLoaded = true;
    });
  }

  constructor(
    private surveyService: SurveyService,
    private userService: UserService
  ) {}
}
