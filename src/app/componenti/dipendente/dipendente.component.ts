import { Component, OnInit } from '@angular/core';
import { DipendenteServiceService } from '../../service/dipendente-service.service';
import { Dipendente } from '../../models/dipendente';

@Component({
  selector: 'app-dipendente',
  templateUrl: './dipendente.component.html',
  styleUrl: './dipendente.component.css'
})
export class DipendenteComponent implements OnInit {

  username = "";
  password = "";
  dipendente?: Dipendente;
  


  constructor(private dipendenteService: DipendenteServiceService){}

  ngOnInit(){
    
  }

  

}
