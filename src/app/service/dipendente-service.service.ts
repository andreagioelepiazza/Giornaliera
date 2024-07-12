import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Dipendente } from '../models/dipendente';
import { Observable } from 'rxjs';
import { SimpleDipendente } from '../models/simple-dipendente';

const baseUrl = 'http://localhost:8080/api/dipendenti'

@Injectable({
  providedIn: 'root'
})
export class DipendenteServiceService {

  constructor(private http: HttpClient) { }

  public create(data: { nome: string; cognome: string; username: string; password: string; }){
    return this.http.post('http://localhost:8080/api/dipendenti/add', data);
  }

  public login(dipendente: SimpleDipendente) :Observable<Dipendente>{
    return this.http.post<Dipendente>('http://localhost:8080/api/dipendenti/login', dipendente)
  }



}
