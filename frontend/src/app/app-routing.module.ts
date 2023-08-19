import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserFormComponent } from './components/user-form/user-form.component';
import { UserRegistrationFormComponent } from './components/user-registration-form/user-registration-form.component';
import { InitialPageComponent } from './components/initial-page/initial-page.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: UserFormComponent },
  { path: 'registration', component: UserRegistrationFormComponent },
  { path: 'initial-page', component: InitialPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
