import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Breeds} from "../model/breeds";
import {BreedInfo} from "../model/breed-info";
import {BreedAdd} from "../model/breed-add";
import {Breed} from "../model/breed";

@Injectable({
  providedIn: 'root'
})
export class BreedService {

  constructor(private http: HttpClient) { }

  getBreeds(): Observable<Breeds>{
    return this.http.get<Breeds>('/dogs/breeds');
  }

  getBreed(uuid: string): Observable<BreedInfo>{
    return this.http.get<BreedInfo>('/dogs/breeds/'+uuid);
  }

  updateBreed(uuid: string, request: BreedAdd): Observable<any>{
    return this.http.patch('/dogs/breeds/'+ uuid, request);
  }

  deleteBreed(uuid: string): Observable<any>{
    return this.http.delete('/dogs/breeds/'+uuid);
  }

  addBreed(request: BreedAdd): Observable<any>{
    return this.http.put('/dogs/breeds', request)
  }
}
