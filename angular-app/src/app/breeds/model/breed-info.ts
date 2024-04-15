import {Pet} from "../../pets/model/pet";

export interface BreedInfo {
  uuid: string;
  name: string;
  height: number;
  pets:Pet[];
}
