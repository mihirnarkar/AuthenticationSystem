import { Component } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private authService: AuthService) {}

  onSubmit(): void {
    this.authService.login(this.username, this.password).subscribe(
      (response: string) => {
        // Handle the response here
        console.log(response);
        
        if (response) {
          // Handle successful login
          console.log('Login successful');
        } else {
          // Handle failed login
          console.log('Login failed');
        }
      },
      (error) => {
        // Handle HTTP error
        console.error('HTTP error:', error);
        // Handle failed login
        console.error('Login failed');
      }
    );
  }
}
