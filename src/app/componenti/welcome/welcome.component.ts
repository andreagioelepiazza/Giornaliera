import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrl: './welcome.component.css'
})
export class WelcomeComponent implements OnInit {

  utente = "";

  Titolo: string = "Benvenuti nella Giornaliera";
  SottoTitolo: string = "Qui puoi dare un occhiata alla tua giornaliera";

  constructor(private route : ActivatedRoute){}

  ngOnInit() : void {
    this.utente = this.route.snapshot.params ["userId"];
  }


}
