import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../interface/auth';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'http://localhost:8080/api/auth';

  constructor(private http: HttpClient) { }

  registerUser(userDetails: User) {
    return this.http.post(`${this.baseUrl}/signup`, userDetails);
  }

  // login(email: string): Observable<User[]> {
  //   return this.http.get<User[]>(`${this.baseUrl}/signin?email=${email}`);
  // }

  login(email: string): Observable<User[]> {
    return this.http.post<User[]>(`${this.baseUrl}/signin`, { email });
  }
}
