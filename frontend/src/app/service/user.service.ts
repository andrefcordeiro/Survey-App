import { HttpBackend, HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';
import * as moment from 'moment';
import { tap } from 'rxjs/operators';
import { UserRole } from '../models/enums/user-role';

@Injectable()
export class UserService {
  private http: HttpClient;

  constructor(httpBackend: HttpBackend) {
    this.http = new HttpClient(httpBackend);
  }

  public userLogin(user: User) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
    };

    return this.http
      .post<User>(
        'https://survey-app-andrefcordeiro-419f85877d9b.herokuapp.com/auth/login',
        user,
        httpOptions
      )
      .pipe(tap((res) => this.setSession(res)));
  }

  public userRegistration(user: User) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
    };

    return this.http.post<User>(
      'https://survey-app-andrefcordeiro-419f85877d9b.herokuapp.com/auth/register',
      user,
      httpOptions
    );
  }

  private setSession(authResult: any) {
    const expiresAt = moment(authResult.expirationDate);

    localStorage.setItem('id_token', authResult.token);
    localStorage.setItem('expires_at', JSON.stringify(expiresAt.valueOf()));
    localStorage.setItem('userId', authResult.userId);
    localStorage.setItem('role', authResult.role);
  }

  logout() {
    localStorage.removeItem('id_token');
    localStorage.removeItem('expires_at');
    localStorage.removeItem('userId');
    localStorage.removeItem('role');
  }

  public isLoggedIn() {
    return this.getToken() && moment().isBefore(this.getExpiration());
  }

  isLoggedOut() {
    return !this.isLoggedIn();
  }

  getExpiration() {
    const expiration = localStorage.getItem('expires_at');
    const expiresAt = JSON.parse(expiration!);
    return moment(expiresAt);
  }

  getToken() {
    return localStorage.getItem('id_token');
  }

  getUserId() {
    return localStorage.getItem('userId');
  }

  getUserRole() {
    return UserRole[localStorage.getItem('role') as keyof typeof UserRole];
  }
}
