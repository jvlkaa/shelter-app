import { Component } from '@angular/core';
import {BreedAdd} from "../../model/breed-add";
import {BreedService} from "../../service/breed.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-breed-add',
  templateUrl: './breed-add.component.html',
  styleUrls: ['./breed-add.component.css']
})
export class BreedAddComponent {
  breed: BreedAdd = { name: '', height: 0}

  constructor(private breedService: BreedService,
              private router: Router,  private route: ActivatedRoute){}

  addBreed(): void{
    if(this.breed.name != '' && this.breed.height != 0){
    this.breedService.addBreed(this.breed!).subscribe(()=>this.router.navigate(['/breeds']))}
  }
}
