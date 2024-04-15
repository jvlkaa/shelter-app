import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Pets} from "../model/pets";
import {PetInfo} from "../model/pet-info";
import {PetEdit} from "../model/pet-edit";
import {PetAdd} from "../model/pet-add";

@Injectable({
  providedIn: 'root'
})
export class PetService {

  constructor(private http: HttpClient) { }

  getPets(): Observable<Pets>{
    return this.http.get<Pets>('/dogs/pets');
  }

  getPet(uuid: string): Observable<PetInfo>{
    return this.http.get<PetInfo>('/dogs/pets/'+uuid);
  }

  getPetsFromBreed(uuid: string): Observable<Pets>{
      return this.http.get<Pets>('dogs/breeds/'+uuid+'/pets');
  }

  updatePet(uuid: string, request: PetEdit): Observable<any>{
    return this.http.patch('/dogs/pets/'+ uuid, request);
  }

  deletePet(uuid: string): Observable<any>{
    return this.http.delete('/dogs/pets/'+uuid);
  }

  addPet(request: PetAdd): Observable<any>{
    return this.http.put('/dogs/pets', request)
  }
}
