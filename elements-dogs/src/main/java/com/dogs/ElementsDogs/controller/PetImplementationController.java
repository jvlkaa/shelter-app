package com.dogs.ElementsDogs.controller;

import com.dogs.ElementsDogs.dto.*;
import com.dogs.ElementsDogs.Pet;
import com.dogs.ElementsDogs.function.*;
import com.dogs.ElementsDogs.breed.DogBreedService;
import com.dogs.ElementsDogs.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
public class PetImplementationController implements PetInterfaceController {
    private final PetService petService;
    private final DogBreedService dogBreedService;
    private final PetResponse petResponse;
    private final PetsResponse petsResponse;
    private final PetRequest petRequest;
    private final PetUpdateRequest petUpdateRequest;

    @Autowired
    public PetImplementationController(PetService petService, DogBreedService dogBreedService, PetResponse petResponse,
           PetsResponse petsResponse, PetUpdateRequest petUpdateRequest ,PetRequest petRequest){
        this.petService = petService;
        this.dogBreedService = dogBreedService;
        this.petResponse = petResponse;
        this.petsResponse = petsResponse;
        this.petRequest = petRequest;
        this.petUpdateRequest = petUpdateRequest;
    }

    @Override
    public GetPet getPet (UUID id) {
        return petService.getPet(id)
                .map(petResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetPets getPets() {
        return petsResponse.apply(petService.getAllPets());
    }

    @Override
    public GetPets getDogBreedPets(UUID dogBreedId) {
        List<Pet> pets = petService.findAllByBreed(dogBreedId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (pets.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return petService.findAllByBreed(dogBreedId)
                .map(petsResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putPet(PutPet new_pet) {
        UUID id = UUID.randomUUID();
        if(dogBreedService.getDogBreedById(new_pet.getBreed()).isPresent()){
            petService.addPet(petRequest.apply(id, new_pet));}
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deletePet(UUID id) {
        petService.getPet(id)
                .ifPresentOrElse(
                        pet -> petService.deletePet(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @Override
    public void updatePet(UUID uuid, UpdatePet update_pet){
        if(petService.getPet(uuid).isPresent()){
            Pet pet = petService.getPet(uuid).get();
            petService.updatePet(uuid, petUpdateRequest.apply(pet, update_pet));
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
