import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Dipendente } from '../models/dipendente';

@Injectable({
  providedIn: 'root'
})
export class AuthorizationService {

  constructor(private http: HttpClient) { }


  autentica = (userid: string, password: string, dipendente: Dipendente): boolean => {
    var retVal = (userid === dipendente.username && password === dipendente.password) ? true : false;

    if(retVal) {
      sessionStorage.setItem("Utente", dipendente?.username!)
    }
    return retVal;
  }

  logout() {
    sessionStorage.removeItem("Utente");
  }

  loggedUser = (): string | null => sessionStorage.getItem("Utente"); 

  isLogged = (): boolean => ((sessionStorage.getItem("Utente") != null) ? true : false);

  clearUser = (): void => sessionStorage.clear();
}
