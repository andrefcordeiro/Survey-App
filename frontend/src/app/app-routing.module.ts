import { NgModule } from '@angular/core';
import {
  RouterModule,
  Routes,
  provideRouter,
  withComponentInputBinding,
} from '@angular/router';
import { UserFormComponent } from './components/user-form/user-form.component';
import { UserRegistrationFormComponent } from './components/user-registration-form/user-registration-form.component';
import { InitialPageComponent } from './components/initial-page/initial-page.component';
import { SurveyPageComponent } from './components/survey-page/survey-page.component';
import { SurveyCreationPageComponent } from './components/survey-creation-page/survey-creation-page.component';
import { AuthorizeGuard } from './service/authorize-guard.service';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: UserFormComponent },
  { path: 'registration', component: UserRegistrationFormComponent },
  {
    path: 'initial-page',
    component: InitialPageComponent,
    canActivate: [AuthorizeGuard],
  },
  {
    path: 'survey/:id',
    component: SurveyPageComponent,
    canActivate: [AuthorizeGuard],
  },
  {
    path: 'survey-creation-page',
    component: SurveyCreationPageComponent,
    canActivate: [AuthorizeGuard],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [provideRouter(routes, withComponentInputBinding())],
})
export class AppRoutingModule {}
