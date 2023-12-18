import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { InterfaceEmploye, PageResponse } from '../employe/employe.component';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeService {

  baseUrl="http://localhost:8081/employe"
  constructor(private http:HttpClient) { }

  getAll(nom?: string, prenom?: string, cin?: string, tel?: string, page = 0, size = 10):Observable<PageResponse>{
    let params = new HttpParams().set('page', page.toString()).set('size', size.toString());

    if (nom) {
      params = params.set('nom', nom);
    }
    if (prenom) {
      params = params.set('prenom', prenom);
    }
    if (cin) {
      params = params.set('cin', cin);
    }
    if (tel) {
      params = params.set('tel', tel);
    }

    return this.http.get<PageResponse>(this.baseUrl, { params });
  }
  getAllE():Observable<PageResponse>{
    return this.http.get<PageResponse>(this.baseUrl);
  }
  add(employe:InterfaceEmploye){
    return this.http.post<InterfaceEmploye>(`${this.baseUrl}`,employe);
  }
}

