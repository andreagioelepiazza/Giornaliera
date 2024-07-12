import { Component, OnInit } from '@angular/core';
import { DipendenteServiceService } from '../../service/dipendente-service.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrl: './signin.component.css'
})
export class SigninComponent implements OnInit {

  dipendente = {
    nome:"",
    cognome:"",
    codIdentificativo:"",
    username:"",
    password:""
  };

  submitted = false;
  
  constructor(private dipendenteService : DipendenteServiceService){}

  ngOnInit(): void {
   
  }

  saveDipendente(){
    const data = {
      nome: this.dipendente.nome,
      cognome: this.dipendente.cognome,
      codIdentificativo: this.dipendente.codIdentificativo,
      username: this.dipendente.username,
      password: this.dipendente.password
    };


    this.dipendenteService.create(data)
    .subscribe(
      response => {
        console.log(response);
        this.submitted = true;
      },
      error => {
        console.log(error);
      }
    )
  }

  newDipendente(){
      this.submitted = false;
      this.dipendente = {
        nome: "",
        cognome: "",
        codIdentificativo: "",
        username: "",
        password: ""
      };
  }

  

}
