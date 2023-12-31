import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css'],
  providers: [UserService],
})
export class UserFormComponent {
  loginForm = this.fb.group({
    username: ['', Validators.required],
    password: ['', Validators.required],
  });

  error: string = '';

  onSubmit() {
    const user: User = new User(
      undefined,
      undefined,
      undefined,
      this.loginForm.value.username!,
      this.loginForm.value.password!,
      undefined
    );

    this.userService.userLogin(user).subscribe({
      next: (val) => {
        this.router.navigate(['/initial-page']);
      },
      error: (e) => {
        console.log(e);

        if (e.status === 403) {
          this.error = 'User does not exists.';
        }
      },
    });
  }

  constructor(
    private fb: FormBuilder,
    private userService: UserService,
    private router: Router
  ) {}
}
