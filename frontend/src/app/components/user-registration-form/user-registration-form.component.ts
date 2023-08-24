import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { User } from 'src/app/models/user';
import { UserRole } from 'src/app/models/enums/user-role';
import { UserService } from 'src/app/service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-registration-form',
  templateUrl: './user-registration-form.component.html',
  styleUrls: ['./user-registration-form.component.css'],
  providers: [UserService],
})
export class UserRegistrationFormComponent {
  registrationForm = this.fb.group({
    name: ['', Validators.required],
    email: ['', Validators.required],
    username: ['', Validators.required],
    password: ['', Validators.required],
    role: [null, Validators.required],
  });

  public userRole = UserRole;

  onSubmit() {
    const user: User = new User(
      undefined,
      this.registrationForm.value.name!,
      this.registrationForm.value.email!,
      this.registrationForm.value.username!,
      this.registrationForm.value.password!,
      this.registrationForm.value.role!
    );

    this.userService.userRegistration(user).subscribe({
      next: (val) => {
        this.router.navigate(['/login']);
      },
      error: (e) => console.log(e),
    });
  }

  constructor(
    private fb: FormBuilder,
    private userService: UserService,
    private router: Router
  ) {}
}
