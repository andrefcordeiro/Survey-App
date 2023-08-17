import { Component, Input } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-radio-input',
  templateUrl: './radio-input.component.html',
  styleUrls: ['./radio-input.component.css'],
})
export class RadioInputComponent {
  @Input() formGroup: FormGroup;
  @Input() fieldName: string;
  @Input() enum: any;
  @Input() enumKeys: string[];
}
