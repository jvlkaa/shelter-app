import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, RouterLink, Router} from "@angular/router";
import {PetService} from "../../../pets/service/pet.service";
import {Pet} from "../../../pets/model/pet";
import {BreedService} from "../../service/breed.service";
import {BreedInfo} from "../../model/breed-info";
import {Pets} from "../../../pets/model/pets";

@Component({
  selector: 'app-breed-view',
  templateUrl: './breed-view.component.html',
  styleUrls: ['./breed-view.component.css']
})
export class BreedViewComponent implements OnInit{

  breed: BreedInfo |undefined;
  pets: Pets | undefined;
  constructor(private petService: PetService, private breedService: BreedService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit(){
    this.route.params.subscribe(params => {
      this.breedService.getBreed(params['uuid'])
        .subscribe(breed => this.breed = breed)
      this.petService.getPetsFromBreed(params['uuid'])
        .subscribe(pets => this.pets = pets)
    });
  }

  delete(pet: Pet): void{
    this.petService.deletePet(pet.uuid).subscribe(() => this.ngOnInit());
  }
}
