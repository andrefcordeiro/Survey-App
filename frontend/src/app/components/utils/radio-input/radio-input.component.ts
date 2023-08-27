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
  @Input() structure: any;
  @Input() isEnum: boolean = false;
  @Input() fieldValueAsIndex: boolean = false; // atribuir o valor de cada campo como sua posição na structure

  getItems() {
    if (this.isEnum) {
      return Object.keys(this.structure).filter((item: any) => {
        return isNaN(Number(item));
      });
    }
    return this.structure;
  }
}
