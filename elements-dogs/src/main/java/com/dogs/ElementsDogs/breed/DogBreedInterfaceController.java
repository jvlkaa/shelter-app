package com.dogs.ElementsDogs.breed;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

//deklaracje metod, definicja zachowan
public interface DogBreedInterfaceController {

    @DeleteMapping("/dogs/breeds/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteDogBreed(
            @PathVariable("uuid")
            UUID uuid
    );

    @PutMapping("/dogs/breeds/{uuid}")
    @ResponseStatus(HttpStatus.CREATED)
    void putDogBreed(
            @PathVariable("uuid")
            UUID uuid
    );
}
