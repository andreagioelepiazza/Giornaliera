import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot } from '@angular/router';
import { AuthorizationService } from './authorization.service';


@Injectable({
  providedIn: 'root'
})

export class RouteGuardServiceService {

  constructor(private basicAuth: AuthorizationService, private route: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){

  if(!this.basicAuth.isLogged){
    this.route.navigate(['login']);
    return false;
  }else {
    return true;
  }
  }
}
