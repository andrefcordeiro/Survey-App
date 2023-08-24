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
      'http://localhost:8080/surveys/' + surveyResponse.surveyId + '/responses',
      surveyResponse,
      httpOptions
    );
  }
}
