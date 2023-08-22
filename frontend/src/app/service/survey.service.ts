import { HttpClient } from '@angular/common/http';
import { Survey } from '../models/survey';
import { UserRole } from '../models/enums/user-role';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class SurveyService {
  public getSurveys(userId: Number, userRole: UserRole): Observable<Survey[]> {
    if (userRole === UserRole.COORDINATOR) {
      return this.http.get<Survey[]>(
        `http://localhost:8080/surveys?coordinator=${userId}`
      );
    }

    return this.http.get<Survey[]>('http://localhost:8080/surveys');
  }

  public getSurveyStatistics(surveyId: Number): Observable<Survey> {
    return this.http.get<Survey>(
      `http://localhost:8080/surveys/${surveyId}/statistics`
    );
  }

  constructor(private http: HttpClient) {}
}
