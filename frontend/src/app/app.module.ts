import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { InitialPageComponent } from './components/initial-page/initial-page.component';
import { SurveyMinComponent } from './components/initial-page/survey-min/survey-min.component';
import { UserFormComponent } from './components/user-form/user-form.component';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { UserRegistrationFormComponent } from './components/user-registration-form/user-registration-form.component';
import { TextInputComponent } from './components/utils/text-input/text-input.component';
import { RadioInputComponent } from './components/utils/radio-input/radio-input.component'; // CLI imports AppRoutingModule
import { AuthInterceptor } from './middlewares/auth-interceptor';
import { UserService } from './service/user.service';
import { SurveyService } from './service/survey.service';
import { SurveyPageComponent } from './components/survey-page/survey-page.component';
import { KeyValueTableComponent } from './components/utils/key-value-table/key-value-table.component';
import { SurveyStatisticsComponent } from './components/survey-page/survey-statistics/survey-statistics.component';
import { NgChartsModule } from 'ng2-charts';
import { SurveyCreationPageComponent } from './components/survey-creation-page/survey-creation-page.component';
import { QuestionCreationComponent } from './components/survey-creation-page/question-creation/question-creation.component';

@NgModule({
  declarations: [
    AppComponent,
    InitialPageComponent,
    SurveyMinComponent,
    UserFormComponent,
    UserRegistrationFormComponent,
    TextInputComponent,
    RadioInputComponent,
    SurveyPageComponent,
    KeyValueTableComponent,
    SurveyStatisticsComponent,
    SurveyCreationPageComponent,
    QuestionCreationComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    NgChartsModule,
  ],
  providers: [
    UserService,
    SurveyService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true,
      deps: [UserService],
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
