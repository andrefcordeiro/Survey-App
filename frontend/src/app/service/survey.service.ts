import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Survey } from '../models/survey';
import { UserRole } from '../models/enums/user-role';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SurveyStatistics } from '../models/survey-statistics';

@Injectable()
export class SurveyService {
  public getSurveys(userId: Number, userRole: UserRole): Observable<Survey[]> {
    if (userRole === UserRole.COORDINATOR) {
      return this.http.get<Survey[]>(
        `https://survey-app-andrefcordeiro-419f85877d9b.herokuapp.com/surveys?coordinator=${userId}`
      );
    }

    return this.http.get<Survey[]>(
      'https://survey-app-andrefcordeiro-419f85877d9b.herokuapp.com/surveys'
    );
  }

  public getSurveyStatistics(surveyId: Number): Observable<SurveyStatistics> {
    return this.http.get<SurveyStatistics>(
      `https://survey-app-andrefcordeiro-419f85877d9b.herokuapp.com/surveys/${surveyId}/statistics`
    );
  }

  public createSurvey(survey: Survey): Observable<Survey> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
    };

    return this.http.post<Survey>(
      'https://survey-app-andrefcordeiro-419f85877d9b.herokuapp.com/surveys',
      survey,
      httpOptions
    );
  }

  public getSurvey(surveyId: Number): Observable<Survey> {
    return this.http.get<Survey>(
      `https://survey-app-andrefcordeiro-419f85877d9b.herokuapp.com/surveys/${surveyId}`
    );
  }

  constructor(private http: HttpClient) {}
}
