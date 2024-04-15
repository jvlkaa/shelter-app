package com.dogs.ElementsDogs.controller;
import com.dogs.ElementsDogs.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

//deklaracje metod, definiujące zachowanie
public interface PetInterfaceController {


    @GetMapping("dogs/pets/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPet getPet(
            @PathVariable("uuid")
            UUID uuid
    );

    @GetMapping("dogs/pets")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPets getPets();


    @GetMapping("dogs/breeds/{dogBreedId}/pets")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPets getDogBreedPets(
            @PathVariable("dogBreedId")
            UUID dogBreedId
    );


    @PutMapping("/dogs/pets")
    @ResponseStatus(HttpStatus.CREATED)
    void putPet(
            @RequestBody
            PutPet putPet
    );

    @DeleteMapping("/dogs/pets/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePet(
            @PathVariable("uuid")
            UUID uuid
    );

    @PatchMapping("/dogs/pets/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    void updatePet(
            @PathVariable("uuid")
            UUID uuid,
            @RequestBody
            UpdatePet updatePet
    );
}
