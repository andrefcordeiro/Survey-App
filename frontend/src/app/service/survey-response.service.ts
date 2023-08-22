import { HttpClient } from '@angular/common/http';
import { UserRole } from '../models/enums/user-role';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Survey } from '../models/survey';

@Injectable()
export class SurveyResponseService {
  constructor(private http: HttpClient) {}
}
