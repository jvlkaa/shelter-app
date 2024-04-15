import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import {BreedAdd} from "../../model/breed-add";
import {BreedService} from "../../service/breed.service";
import {ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-breed-edit',
  templateUrl: './breed-edit.component.html',
  styleUrls: ['./breed-edit.component.css']
})
export class BreedEditComponent implements OnInit {
  uuid: string | undefined;
  breed: BreedAdd | undefined;

  constructor(private breedService: BreedService,
  private router: Router,  private route: ActivatedRoute){}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.breedService.getBreed(params['uuid'])
        .subscribe(breed => {
          this.uuid = breed.uuid;
          this.breed = {
            name: breed.name,
            height: breed.height,
          };
        });
    });
  }

  updateBreed(): void{
    this.breedService.updateBreed(this.uuid!, this.breed!).subscribe(()=>this.router.navigate(['/breeds']))
  }
}
