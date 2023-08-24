import { Component, Input, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Question } from 'src/app/models/question';
import { QuestionResponse } from 'src/app/models/question-response';
import { Survey } from 'src/app/models/survey';
import { SurveyResponse } from 'src/app/models/survey-response';
import { SurveyResponseService } from 'src/app/service/survey-response.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-survey-response',
  templateUrl: './survey-response.component.html',
  styleUrls: ['./survey-response.component.css'],
})
export class SurveyResponseComponent implements OnInit {
  @Input() survey: Survey;
  userAlreadyResponded: boolean = false;

  surveyResponseForm: FormGroup = this.fb.group({
    questionResponses: this.fb.array([]),
  });

  ngOnInit() {
    this.checkIfUserAlreadyRespondedSurvey();

    if (!this.userAlreadyResponded) {
      this.createForm();
    }
  }

  private checkIfUserAlreadyRespondedSurvey() {
    const userId: number = Number(this.userService.getUserId());

    this.surveyResponseService
      .getUserResponse(this.survey.id!, userId)
      .subscribe({
        next: () => {
          this.userAlreadyResponded = true;
        },
        error: () => {
          this.userAlreadyResponded = false;
        },
      });
  }

  getQuestion(index: number): Question {
    return this.survey.questions![index];
  }

  getOptions(questionIndex: number): string[] {
    return this.survey.questions![questionIndex].options;
  }

  questionResponses(): FormArray {
    return this.surveyResponseForm.get('questionResponses') as FormArray;
  }

  getQuestionResponse(index: number): FormGroup {
    return this.questionResponses().controls[index] as FormGroup;
  }

  private createForm() {
    for (let q of this.survey.questions!) {
      this.questionResponses().push(this.newQuestionResponse(q.id!));
    }
  }

  private newQuestionResponse(questionId: number): FormGroup {
    return this.fb.group({
      questionId: questionId,
      optionSelected: ['', Validators.required],
    });
  }

  onSubmit() {
    console.log(this.surveyResponseForm.value);

    const questionsResponses: QuestionResponse[] =
      this.surveyResponseForm.value.questionResponses;

    const surveyResponse: SurveyResponse = new SurveyResponse(
      this.survey.id!,
      questionsResponses
    );

    console.log(surveyResponse);

    this.surveyResponseService.submitSurvey(surveyResponse).subscribe({
      next: (val) => {
        this.router.navigate(['/initial-page']);
      },
      error: (e) => console.log(e),
    });
  }

  constructor(
    private fb: FormBuilder,
    private surveyResponseService: SurveyResponseService,
    private userService: UserService,
    private router: Router
  ) {}
}
