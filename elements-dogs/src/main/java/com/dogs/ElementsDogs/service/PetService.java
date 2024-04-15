package com.dogs.ElementsDogs.service;

import com.dogs.ElementsDogs.Pet;
import com.dogs.ElementsDogs.breed.DogBreedRepository;
import com.dogs.ElementsDogs.repository.PetRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Getter
@Setter
public class PetService {

    private final PetRepository petRepository;
    private final DogBreedRepository dogBreedRepository;

    @Autowired
    public PetService(PetRepository petRepository, DogBreedRepository dogBreedRepository) {
        this.petRepository = petRepository;
        this.dogBreedRepository = dogBreedRepository;
    }

    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }


    public Optional<List<Pet>> findAllByBreed(UUID id) {
        return dogBreedRepository.findById(id)
                .map(petRepository::findAllByBreed);
    }

    public Optional<Pet> getPet(UUID id){ return petRepository.findById(id); }

    public Pet updatePet(UUID id, Pet updatedPet) {
        Pet existingPet = petRepository.findById(id).orElse(null);
        if (existingPet != null) {
            updatedPet.setUuid(existingPet.getUuid());
            return petRepository.save(updatedPet);
        } else {
            return null;
        }
    }

    public boolean deletePet(UUID id) {
        Pet existingPet = petRepository.findById(id).orElse(null);
        if (existingPet != null) {
            petRepository.delete(existingPet);
            return true;
        } else {
            return false;
        }
    }
}