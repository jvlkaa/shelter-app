import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {BreedListComponent} from "./breeds/view/breed-list/breed-list.component";
import {BreedViewComponent} from "./breeds/view/breed-view/breed-view.component";
import {BreedEditComponent} from "./breeds/view/breed-edit/breed-edit.component";
import {BreedAddComponent} from "./breeds/view/breed-add/breed-add.component";
import {PetViewComponent} from "./pets/view/pet-view/pet-view.component";
import {PetEditComponent} from "./pets/view/pet-edit/pet-edit.component";
import {PetAddComponent} from "./pets/view/pet-add/pet-add.component";


const routes: Routes = [
  {
    component: BreedListComponent,
    path: 'breeds'
  },
  {
    component: BreedViewComponent,
    path: 'breeds/:uuid'
  },
  {
    component: BreedEditComponent,
    path: 'breeds/:uuid/edit'
  },
  {
    component: BreedAddComponent,
    path: 'addbreed'
  },
  {
    component: PetViewComponent,
    path: 'breeds/:uuidb/pets/:uuidp'
  },
  {
    component: PetEditComponent,
    path: 'breeds/:uuidb/pets/:uuidp/edit'
  },
  {
    component: PetAddComponent,
    path: 'breeds/:uuid/addpet'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
