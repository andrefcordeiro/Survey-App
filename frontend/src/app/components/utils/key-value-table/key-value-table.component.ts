import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-key-value-table',
  templateUrl: './key-value-table.component.html',
  styleUrls: ['./key-value-table.component.css'],
})
export class KeyValueTableComponent {
  @Input() map: any;
}
