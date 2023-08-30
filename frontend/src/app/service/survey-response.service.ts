import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SurveyResponse } from '../models/survey-response';
import { Observable } from 'rxjs';

@Injectable()
export class SurveyResponseService {
  constructor(private http: HttpClient) {}

  public submitSurvey(
    surveyResponse: SurveyResponse
  ): Observable<SurveyResponse> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
    };

    return this.http.post<SurveyResponse>(
      'https://survey-app-andrefcordeiro-419f85877d9b.herokuapp.com/surveys/' +
        surveyResponse.surveyId +
        '/responses',
      surveyResponse,
      httpOptions
    );
  }

  public getUserResponse(
    surveyId: number,
    respondentId: number
  ): Observable<SurveyResponse> {
    return this.http.get<SurveyResponse>(
      'https://survey-app-andrefcordeiro-419f85877d9b.herokuapp.com/surveys/' +
        surveyId +
        '/responses?respondent=' +
        respondentId
    );
  }
}
