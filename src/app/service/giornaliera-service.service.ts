import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Giornaliera } from '../models/giornaliera';
import { GiornalieraDto } from '../models/giornaliera-dto';
import { Router } from '@angular/router';


const giornalieraUrl= "http://localhost:8080/api/giornaliera";

@Injectable({
  providedIn: 'root'
})
export class GiornalieraServiceService {

  


  constructor(private http: HttpClient) { 
  }

  get(id: number) : Observable<GiornalieraDto> {
    return this.http.get<GiornalieraDto>(`http://localhost:8080/api/giornaliera/giornaliera/${id}`);
  }


  public findAll():Observable<Giornaliera[]> {
    return this.http.get<Giornaliera[]>("http://localhost:8080/api/giornaliera");
  }

  public findUsername(username: string, click: number): Observable<GiornalieraDto[]>{
    return this.http.get<GiornalieraDto[]> (`${giornalieraUrl}/giornaliere?username=${username}&click=${click}`)
  }

  update(id: number, data: GiornalieraDto) {
    return this.http.put(`${giornalieraUrl}/update/${id}`, data);
  }

}
