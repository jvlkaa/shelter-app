package com.dogs.ElementsDogs.breed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.UUID;

@RestController
public class DogBreedImplementationController implements DogBreedInterfaceController {
    private final DogBreedService service;

    @Autowired
    public DogBreedImplementationController(DogBreedService service){
        this.service = service;
    }

    @Override
    public void deleteDogBreed(UUID id) {
        service.getDogBreedById(id)
                .ifPresentOrElse(
                        breed -> service.deleteDogBreed(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @Override
    public void putDogBreed(UUID uuid) {
        DogBreed dogBreed = DogBreed.builder()
                .uuid(uuid)
                .pets(new ArrayList<>())
                .build();
        service.addDogBreed(dogBreed);
    }
}
