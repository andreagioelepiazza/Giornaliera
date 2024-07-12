import { Component, OnInit } from '@angular/core';
import { FilmServiceService } from '../../services/film-service.service';

export class FilmClass { 
  constructor ( 
  public id: number, 
  public titolo: string, 
  public anno: string, 
  public genere: string 
  ) {} 
 } 

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrl: './film.component.css'
})
export class FilmComponent implements OnInit {

  films : any;
  currentFilm = null;
  
   constructor(private filmService : FilmServiceService) { } 
   
   ngOnInit(): void {
    this.retrieveFilms();
   }

   retrieveFilms(){
    this.filmService.getAll()
    .subscribe(
      data => {this.films = data;
      console.log(data);
    },
  error => {console.log(error);
  });
   }

}
