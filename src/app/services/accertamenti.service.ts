import { ActivatedRouteSnapshot, Router, RouterStateSnapshot, UrlTree } from 
'@angular/router'; 
import { AutorizzazioniService } from './autorizzazioni.service'; 
import { Injectable } from '@angular/core'; 
@Injectable({ 
 providedIn: 'root' 
}) 
export class AccertamentiService { 

//  constructor(private BasicAuth: AutorizzazioniService, private route: Router) { } 
 
//  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) { 
//  if (!this.BasicAuth.isLogged()) { 
//  this.route.navigate(['login']); 
//  return false; 
//  } else { 
//  return true; 
//  } 
//  } 

constructor(private BasicAuth: AutorizzazioniService, private route: Router) {}

canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if(!this.BasicAuth.isLogged()) {
        this.route.navigate(['login']);
        return false;
    }  else {
        return true;
    }
}

}
