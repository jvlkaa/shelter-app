import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {PetAddComponent} from "./pets/view/pet-add/pet-add.component";
import {PetViewComponent} from "./pets/view/pet-view/pet-view.component";
import {PetEditComponent} from "./pets/view/pet-edit/pet-edit.component";
import {BreedViewComponent} from "./breeds/view/breed-view/breed-view.component";
import {BreedEditComponent} from "./breeds/view/breed-edit/breed-edit.component";
import {BreedListComponent} from "./breeds/view/breed-list/breed-list.component";
import {BreedAddComponent} from "./breeds/view/breed-add/breed-add.component";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {PetService} from "./pets/service/pet.service";
import {BreedService} from "./breeds/service/breed.service";

@NgModule({
  declarations: [
    AppComponent,
    PetAddComponent,
    PetViewComponent,
    PetEditComponent,
    BreedViewComponent,
    BreedEditComponent,
    BreedListComponent,
    BreedAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    PetService,
    BreedService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
