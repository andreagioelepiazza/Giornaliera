import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const baseUrl = 'http//localhost:8080/api/film'

@Injectable({
  providedIn: 'root'
})

export class FilmServiceService {

  constructor(private Http: HttpClient) { }

  getAll(){
    return this.Http.get('${baseUrl}/films');
  }
}
