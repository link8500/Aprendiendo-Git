import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { contact } from '../Model/Contact.interface';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  private http = inject(HttpClient);

  list() {
    return this.http.get<contact[]>('http://localhost:8080/api/v1/empleados');
  }

  get(id: number) {
    return this.http.get<contact>(`http://localhost:8080/api/v1/${id}`);
  }

  create(contact: contact) {
    return this.http.post<contact>('http://localhost:8080/api/v1/', contact);
  }

  uptade(id: number, contact: contact) {
    return this.http.put<contact>(`http://localhost:8080/api/v1/${id}`, contact);
  }

  delete(id: number) {
    return this.http.delete<void>(`http://localhost:8080/api/v1/${id}`);
  }

}
