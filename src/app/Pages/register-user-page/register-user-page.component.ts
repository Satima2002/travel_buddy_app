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
    
    registerForm: FormGroup;

    constructor(private router: Router, private fb: FormBuilder) {
      this.registerForm = this.fb.group({
        userName: ['', Validators.required],
        firstName: ['', Validators.required],
        lastName: ['', Validators.required],
        dob: ['', Validators.required],
        email: ['', [Validators.required, Validators.email]],
        password: ['', Validators.required],
        gender: ['', Validators.required], // Add gender field here
        description: ['']
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
