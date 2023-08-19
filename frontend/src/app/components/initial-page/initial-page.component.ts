import { Component } from '@angular/core';
import { UserService } from 'src/app/service/user.service';
import { SurveyService } from 'src/app/service/survey.service';
import { UserRole } from 'src/app/models/enums/user-role';
import { Survey } from 'src/app/models/survey';

@Component({
  selector: 'app-initial-page',
  templateUrl: './initial-page.component.html',
  styleUrls: ['./initial-page.component.css'],
  providers: [SurveyService, UserService],
})
export class InitialPageComponent {
  surveys: Survey[] = [];

  ngOnInit() {
    this.getSurveys();
  }

  getSurveys() {
    const userRole: UserRole = this.userService.getUserRole();
    const userId: Number = Number(this.userService.getUserId());
    this.surveyService.getSurveys(userId, userRole).subscribe((res) => {
      this.surveys = res;
    });
  }

  constructor(
    private surveyService: SurveyService,
    private userService: UserService
  ) {}
}
