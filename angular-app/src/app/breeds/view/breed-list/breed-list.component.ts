import {Component, OnInit} from '@angular/core';
import {BreedService} from "../../service/breed.service";
import {Breeds} from "../../model/breeds";
import {Breed} from "../../model/breed";
@Component({
  selector: 'app-breed-list',
  templateUrl: './breed-list.component.html',
  styleUrls: ['./breed-list.component.css']
})
export class BreedListComponent implements OnInit{
  constructor(private service: BreedService) {
  }

  breeds: Breeds | undefined;

  ngOnInit(): void{
    this.service.getBreeds().subscribe(breeds => this.breeds = breeds);
  }

  delete(breed: Breed): void{
    this.service.deleteBreed(breed.uuid).subscribe(() => this.ngOnInit());
  }
}
