import { ChangeDetectorRef, Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Question } from 'src/app/models/question';
import { Survey } from 'src/app/models/survey';
import { SurveyService } from 'src/app/service/survey.service';
import { ArrayValidators } from 'src/app/service/validators/array.validators';

@Component({
  selector: 'app-survey-creation-page',
  templateUrl: './survey-creation-page.component.html',
  styleUrls: ['./survey-creation-page.component.css'],
})
export class SurveyCreationPageComponent {
  surveyCreationForm = this.fb.nonNullable.group({
    title: ['', Validators.required],
    timeframe: [new Date(), Validators.required],
    questions: this.fb.nonNullable.array<Question>(
      [],
      [ArrayValidators.minLength(1), ArrayValidators.maxLength(10)]
    ),
  });

  ngOnInit() {
    this.addQuestion();
  }

  questions(): FormArray {
    return this.surveyCreationForm.get('questions') as FormArray;
  }

  newQuestion(): FormGroup {
    return this.fb.group({
      text: '',
      options: this.fb.array(
        [],
        [ArrayValidators.minLength(2), ArrayValidators.maxLength(5)]
      ),
    });
  }

  addQuestion() {
    this.questions().push(this.newQuestion());
    this.changeDetectorRef.detectChanges();
  }

  private formatQuestionsForRequest() {
    let questions: Question[] = [];
    const questionsFormArray = this.questions();

    for (let i = 0; i < questionsFormArray.controls.length; i++) {
      const qFormGroup = questionsFormArray.controls[i].value;

      // options
      const options: string[] = [];
      const optionsArray = qFormGroup['options'];
      for (let j = 0; j < optionsArray.length; j++) {
        options.push(optionsArray[j]['option']);
      }

      const q: Question = new Question(undefined, qFormGroup['text'], options);

      questions.push(q);
    }

    return questions;
  }

  onSubmit() {
    let questions: Question[] = this.formatQuestionsForRequest();

    const survey: Survey = new Survey(
      undefined,
      this.surveyCreationForm.value.title!,
      this.surveyCreationForm.value.timeframe!,
      undefined,
      undefined,
      undefined,
      questions!
    );

    this.surveyService.createSurvey(survey).subscribe({
      next: (val) => {
        console.log(val);
        this.router.navigate([`/survey/${val.id}`]);
      },
      error: (e) => console.log(e),
    });
  }

  constructor(
    private fb: FormBuilder,
    private readonly changeDetectorRef: ChangeDetectorRef,
    private surveyService: SurveyService,
    private router: Router
  ) {}
}
