import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KeyValueTableComponent } from './key-value-table.component';

describe('TableComponent', () => {
  let component: KeyValueTableComponent;
  let fixture: ComponentFixture<KeyValueTableComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [KeyValueTableComponent],
    });
    fixture = TestBed.createComponent(KeyValueTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
