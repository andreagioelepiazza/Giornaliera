import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AutorizzazioniService {

  constructor() { }

  autentica = (userid: string, password: string): boolean => {
    var retVal = (userid === "pippo" && password === "1234") ? true : false;

    if(retVal) {
      sessionStorage.setItem("Utente", userid)
    }
    return retVal;
  }


  loggedUser = (): string | null =>  (sessionStorage.getItem("Utente"));

  isLogged = (): boolean => (sessionStorage.getItem("Utente") != null ? true : false);

  clearUser = (): void => sessionStorage.clear();

}
