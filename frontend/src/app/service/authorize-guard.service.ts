import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  Router,
  UrlTree,
} from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from './user.service';
import { UserRole } from '../models/enums/user-role';

@Injectable({
  providedIn: 'root',
})
export class AuthorizeGuard {
  coordinatorOnlyRoutes = ['survey-creation-page'];

  constructor(private userService: UserService, private router: Router) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean {
    const nextPath = next.routeConfig!.path;

    if (this.userService.isLoggedIn()) {
      if (
        this.coordinatorOnlyRoutes.includes(nextPath!) &&
        this.userService.getUserRole() === UserRole.RESPONDENT
      ) {
        this.router.navigate(['/login']);
        return false;
      }
      return true;
    }
    this.router.navigate(['/login']);
    return false;
  }
}
