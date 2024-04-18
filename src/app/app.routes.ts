import { Routes } from '@angular/router';
import { WelcomePageComponent } from './Pages/welcome-page/welcome-page.component';
import { LoginPageComponent } from './Pages/login-page/login-page.component';
import { UserHomePageComponent } from './Pages/user-home-page/user-home-page.component';
import { RegisterUserPageComponent } from './Pages/register-user-page/register-user-page.component';

export const routes: Routes = [
    { path: '', component:WelcomePageComponent, title: 'Welcome page'},
    { path: 'login', component:LoginPageComponent, title: 'Login page'},
    { path: 'user-home', component:UserHomePageComponent, title: 'Home page'},
    { path: 'register-user', component:RegisterUserPageComponent, title:'Register user page'}

];
