import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PetEdit} from "../../model/pet-edit";
import {PetService} from "../../service/pet.service";

@Component({
  selector: 'app-pet-edit',
  templateUrl: './pet-edit.component.html',
  styleUrls: ['./pet-edit.component.css']
})
export class PetEditComponent {
  uuid: string | undefined;
  uuidBreed: string |undefined;
  pet: PetEdit| undefined;

  constructor(private petService: PetService,
              private router: Router,  private route: ActivatedRoute){}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.petService.getPet(params['uuidp'])
        .subscribe(pet => {
          this.uuid = pet.uuid;
          this.uuidBreed = params['uuidb'];
          this.pet = {
            name: pet.name,
            age: pet.age,
          };
        });
    });
  }

  updatePet(): void{
    this.petService.updatePet(this.uuid!, this.pet!).subscribe(()=>this.router.navigate(['/breeds/'+this.uuidBreed]))
  }
}
