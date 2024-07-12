import { Component } from '@angular/core';
import { AuthorizationService } from '../../service/authorization.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
})
export class NavbarComponent {
  constructor(private route: Router, public BasicAuth: AuthorizationService) {}

  gestioneLogout() {
    this.BasicAuth.logout();
    this.route.navigate(['/login']);
  }
}
