import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PetService} from "../../service/pet.service";
import {PetAdd} from "../../model/pet-add";

@Component({
  selector: 'app-pet-add',
  templateUrl: './pet-add.component.html',
  styleUrls: ['./pet-add.component.css']
})
export class PetAddComponent {
  uuidBreed: string | undefined;
  pet: PetAdd = { name: '', age: 0, breed: ''}

  constructor(private petService: PetService,
              private router: Router,  private route: ActivatedRoute){}

  ngOnInit(){
    this.route.params.subscribe(params => {
      this.pet.breed = params['uuid']
    });
  }

  addPet(): void{
    if(this.pet.name != '' && this.pet.age != 0){
      this.petService.addPet(this.pet!).subscribe(()=>this.router.navigate(['/breeds/'+this.pet.breed]))}
  }
}
