import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { InitialPageComponent } from './components/initial-page/initial-page.component';
import { SurveyMinComponent } from './components/initial-page/survey-min/survey-min.component';
import { UserFormComponent } from './components/user-form/user-form.component';

import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { UserRegistrationFormComponent } from './components/user-registration-form/user-registration-form.component';
import { TextInputComponent } from './components/utils/text-input/text-input.component';
import { RadioInputComponent } from './components/utils/radio-input/radio-input.component'; // CLI imports AppRoutingModule

@NgModule({
  declarations: [
    AppComponent,
    InitialPageComponent,
    SurveyMinComponent,
    UserFormComponent,
    UserRegistrationFormComponent,
    TextInputComponent,
    RadioInputComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
