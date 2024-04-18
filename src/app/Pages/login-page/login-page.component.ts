import { Component, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl, FormGroup, ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import { NgModule } from '@angular/core';
import { NgModel } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [],
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.css'
})

@Injectable({
  providedIn: 'root'
})
export class LoginPageComponent {
  
  email: string = '';
  password: string = '';
  loginForm: FormGroup;
  
    constructor(private router: Router, private fb: FormBuilder, private http: HttpClient) {
      this.loginForm = this.fb.group({
        email: ['', [Validators.required, Validators.email]], 
        password: ['', Validators.required]
      });
    }
    login() {
      console.log('Form values:', this.loginForm.value);

    if((this.password = '12345') && (this.email='oshidiweerakulasuriya@gmail.com')){
        this.router.navigate(['/user-home']); 
    } else {
      alert('Please enter a valid email and password');
    }
  }
  registerUser() {
    this.router.navigate(['/register-user']);
  }
}