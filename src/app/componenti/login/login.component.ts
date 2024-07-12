import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthorizationService } from '../../service/authorization.service';
import { Dipendente } from '../../models/dipendente';
import { DipendenteServiceService } from '../../service/dipendente-service.service';
import { SimpleDipendente } from '../../models/simple-dipendente';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  dipendente = new Dipendente;
  userId = "";
  password = "";
  autenticato = false;
  errorMsg = "Spiacente, la userId o la password non sono corretti.";
  Titolo: string = "Accesso & Autenticazione"; 
  SottoTitolo: string = "Procedi inserendo la userid e la password"; 

  constructor(private dipendenteService : DipendenteServiceService, private route: Router, private BasicAuth: AuthorizationService){}


  gestioneLogin(){
    this.dipendenteService.login(new SimpleDipendente(this.userId, this.password)).subscribe({
      next: (data) => {
        this.dipendente = data;
        if(this.BasicAuth.autentica(this.userId, this.password, this.dipendente)){
          this.route.navigate(['welcome'])
        }
      },
      error: (e) => {
        console.error("Errore durante la richiesta HTTP: " , e.message);
      }
    });
  }

}
