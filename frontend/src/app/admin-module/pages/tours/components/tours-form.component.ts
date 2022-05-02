import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-tours-form',
  templateUrl: './tours-form.component.html',
  styleUrls: ['./tours-form.component.scss'],
})
export class ToursFormComponent {
  tourForm: FormGroup = this.formBuilder.group({
    imageUri: ['', [Validators.required]],
    country: ['', Validators.required],
    district: ['', Validators.required],
    destination: ['', Validators.required],
    description: ['', Validators.required],
    introduction: ['', Validators.required],
    checkIn: ['', Validators.required],
    checkOut: ['', Validators.required],
    price: ['', Validators.required],
    promotion: ['', Validators.required],
  });

  constructor(private formBuilder: FormBuilder) {}

  public onSubmit(): void {}
}
