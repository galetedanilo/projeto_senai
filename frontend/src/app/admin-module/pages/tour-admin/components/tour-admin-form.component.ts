import { Component, SkipSelf } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { IGRUDService } from 'src/app/core/services/interfaces/grud-service.interface';
import { ITourAdminResponse } from '../responses/tour-admin-response.interface';

@Component({
  selector: 'tour-admin-form',
  templateUrl: './tour-admin-form.component.html',
  styleUrls: ['./tour-admin-form.component.scss'],
})
export class TourAdminFormComponent {
  formTour: FormGroup = this.formBuilder.group({
    imageUri: ['', [Validators.required, Validators.minLength(4)]],
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

  public tourAdminResponse!: ITourAdminResponse;

  constructor(
    private formBuilder: FormBuilder,
    @SkipSelf() private tourAdminService: IGRUDService
  ) {}

  public onSubmit(): void {
    this.tourAdminService.create(this.formTour.value).subscribe({
      next: (response) => (console.log(response)),
      error: (err) => console.log(err),
    });
    this.formTour.reset();
    
  
  }
}
