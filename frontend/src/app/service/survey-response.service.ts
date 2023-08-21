import { HttpClient } from '@angular/common/http';
import { UserRole } from '../models/enums/user-role';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SurveyResponse } from '../models/survey-response';

@Injectable()
export class SurveyResponseService {
  public getSurvey(
    surveyId: Number,
    userRole: UserRole
  ): Observable<SurveyResponse> {
    // if (userRole === UserRole.COORDINATOR) {
    return this.http.get<SurveyResponse>(
      `http://localhost:8080/surveys/${surveyId}/statistics`
    );
    // }

    // return this.http.get<SurveyResponse[]>('http://localhost:8080/surveys');
  }

  constructor(private http: HttpClient) {}
}
