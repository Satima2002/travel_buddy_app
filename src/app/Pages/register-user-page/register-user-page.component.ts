import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl, FormGroup, ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-register-user-page',
  standalone: true,
  imports: [],
  templateUrl: './register-user-page.component.html',
  styleUrl: './register-user-page.component.css'
})
export class RegisterUserPageComponent {
  characterCount: number = 0;
  descriptionControl = new FormControl('');
  userName: string = '';
    firstName: string = '';
    lastName: string = '';
    dob: string = '';
   email: string = '';
  password: string = '';
    //profilePhoto: string = '';
    description: string = '';
    registerForm: FormGroup;

    constructor(private router: Router, private fb: FormBuilder) {
      this.registerForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
      });
    }

    ngOnInit() {
      this.descriptionControl.valueChanges.subscribe(value => {
        this.characterCount = 500;
      });
    }

    register() {
    console.log('Form values:', this.registerForm.value);

      this.router.navigate(['/login']); 
}

}
