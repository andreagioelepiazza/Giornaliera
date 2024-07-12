import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, Router, RouterStateSnapshot} from "@angular/router";
import { AuthorizationService } from './authorization.service';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class RouteGuardService {

  constructor(private BasicAuth: AuthorizationService, private route: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(!this.BasicAuth.isLogged()){
      this.route.navigate(["login"]);
      return false;
    }else{
      return true;
    }
  }

}
