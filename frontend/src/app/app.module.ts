import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { InitialPageComponent } from './components/initial-page/initial-page.component';
import { SurveyMinComponent } from './components/initial-page/survey-min/survey-min.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import { UserRegisterFormComponent } from './components/user-register-form/user-register-form.component';

import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    InitialPageComponent,
    SurveyMinComponent,
    UserFormComponent,
    UserRegisterFormComponent,
  ],
  imports: [BrowserModule, HttpClientModule, FormsModule, ReactiveFormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
