package com.dogs.CategoriesDogs.controller;

import com.dogs.CategoriesDogs.DogBreed;
import com.dogs.CategoriesDogs.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

//deklaracje metod, definicja zachowan
public interface DogBreedInterfaceController {

    @GetMapping("dogs/breeds/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetDogBreed getDogBreed(
            @PathVariable("uuid")
            UUID uuid
    );

    @GetMapping("dogs/breeds")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetDogBreeds getDogBreeds();


    @PutMapping("/dogs/breeds")
    @ResponseStatus(HttpStatus.CREATED)
    void putDogBreed(
            @RequestBody
            PutDogBreed putDogBreed
    );

    @DeleteMapping("/dogs/breeds/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteDogBreed(
            @PathVariable("uuid")
            UUID uuid
    );

    @PatchMapping("/dogs/breeds/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    DogBreed updateBreed(
            @PathVariable("uuid")
            UUID uuid,
            @RequestBody
            UpdateBreed updateBreed
    );
}
