import { Component, Input } from "@angular/core";
import { FormBuilder, Validators } from "@angular/forms";
import { User } from "src/app/models/user";
import { UserService } from "src/app/service/user.service";

@Component({
  selector: "app-user-form",
  templateUrl: "./user-form.component.html",
  styleUrls: ["./user-form.component.css"],
  providers: [UserService],
})
export class UserFormComponent {
  loginForm = this.fb.group({
    username: ["", Validators.required],
    password: ["", Validators.required],
  });

  onSubmit() {
    const user: User = new User(
      undefined,
      undefined,
      undefined,
      this.loginForm.value.username!,
      this.loginForm.value.password!,
      undefined
    );

    this.userService.userLogin(user).subscribe();
  }

  constructor(private fb: FormBuilder, private userService: UserService) {}
}
