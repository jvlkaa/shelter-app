import { Component } from '@angular/core';
import {BreedInfo} from "../../../breeds/model/breed-info";
import {PetService} from "../../service/pet.service";
import {BreedService} from "../../../breeds/service/breed.service";
import {ActivatedRoute, Router} from "@angular/router";
import {PetInfo} from "../../model/pet-info";
@Component({
  selector: 'app-pet-view',
  templateUrl: './pet-view.component.html',
  styleUrls: ['./pet-view.component.css']
})
export class PetViewComponent {
  pet: PetInfo | undefined;
  breed: BreedInfo | undefined;

  constructor(private petService: PetService, private breedService: BreedService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit(){
    this.route.params.subscribe(params => {
      this.petService.getPet(params['uuidp'])
        .subscribe(pet => this.pet = pet)
      this.breedService.getBreed(params['uuidb'])
        .subscribe(breed => this.breed = breed)
    });
  }

}
