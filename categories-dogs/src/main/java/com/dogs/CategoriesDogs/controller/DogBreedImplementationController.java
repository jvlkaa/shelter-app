package com.dogs.CategoriesDogs.controller;

import com.dogs.CategoriesDogs.DogBreed;
import com.dogs.CategoriesDogs.dto.PutDogBreed;
import com.dogs.CategoriesDogs.dto.UpdateBreed;
import com.dogs.CategoriesDogs.dto.GetDogBreed;
import com.dogs.CategoriesDogs.dto.GetDogBreeds;
import com.dogs.CategoriesDogs.function.DogBreedRequest;
import com.dogs.CategoriesDogs.function.DogBreedResponse;
import com.dogs.CategoriesDogs.function.DogBreedUpdateRequest;
import com.dogs.CategoriesDogs.function.DogBreedsResponse;
import com.dogs.CategoriesDogs.service.DogBreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class DogBreedImplementationController implements DogBreedInterfaceController {
    private final DogBreedService service;
    private final DogBreedResponse dogBreedResponse;
    private final DogBreedsResponse dogBreedsResponse;
    private final DogBreedRequest dogBreedRequest;
    private final DogBreedUpdateRequest dogBreedUpdateRequest;

    @Autowired
    public DogBreedImplementationController(DogBreedService service, DogBreedResponse dogBreedResponse, DogBreedsResponse dogBreedsResponse,
            DogBreedRequest dogBreedRequest, DogBreedUpdateRequest dogBreedUpdateRequest){
        this.service = service;
        this.dogBreedResponse = dogBreedResponse;
        this.dogBreedsResponse = dogBreedsResponse;
        this.dogBreedRequest = dogBreedRequest;
        this.dogBreedUpdateRequest = dogBreedUpdateRequest;
    }

    @Override
    public GetDogBreed getDogBreed(UUID id) {
        return service.getDogBreedById(id)
                .map(dogBreedResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetDogBreeds getDogBreeds() {
        return dogBreedsResponse.apply(service.getAllDogBreeds());
    }

    @Override
    public void putDogBreed(PutDogBreed request) {
        UUID id = UUID.randomUUID();
        service.addDogBreed(dogBreedRequest.apply(id, request));
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
    public DogBreed updateBreed(UUID uuid, UpdateBreed request){
        if(service.getDogBreedById(uuid).isPresent()){
            DogBreed breed = service.getDogBreedById(uuid).get();
            return service.updateDogBreed(uuid, dogBreedUpdateRequest.apply(breed, request));
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
