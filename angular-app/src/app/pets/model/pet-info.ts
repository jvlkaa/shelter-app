import {Breed} from "../../breeds/model/breed";

export interface PetInfo {

  uuid: string;
  name: string;
  age: number;
  breed: Breed;
}
