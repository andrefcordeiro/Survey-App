import { ChangeDetectorRef, Component, Input } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-question-creation',
  templateUrl: './question-creation.component.html',
  styleUrls: ['./question-creation.component.css'],
})
export class QuestionCreationComponent {
  @Input() questions: FormArray;
  @Input() questionIndex: number;

  ngOnInit() {
    this.addOption();
    this.addOption();
  }

  getQuestion(i: number): FormGroup {
    return this.questions.controls[i] as FormGroup;
  }

  removeQuestion(i: number) {
    this.questions.removeAt(i);
    this.changeDetectorRef.detectChanges();
  }

  // Options
  options(): FormArray {
    return this.questions.controls[this.questionIndex].get(
      'options'
    ) as FormArray;
  }

  getOption(i: number): FormGroup {
    return this.options().controls[i] as FormGroup;
  }

  newOption(): FormGroup {
    return this.fb.group({
      option: '',
    });
  }

  addOption() {
    this.options().push(this.newOption());
    this.changeDetectorRef.detectChanges();
  }

  removeOption(i: number) {
    this.options().removeAt(i);
    this.changeDetectorRef.detectChanges();
  }

  constructor(
    private fb: FormBuilder,
    private readonly changeDetectorRef: ChangeDetectorRef
  ) {}
}
