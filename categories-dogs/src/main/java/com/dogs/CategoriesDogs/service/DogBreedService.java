package com.dogs.CategoriesDogs.service;

import com.dogs.CategoriesDogs.DogBreed;
import com.dogs.CategoriesDogs.repository.DogBreedRepository;
import com.dogs.CategoriesDogs.rest.DogBreedRest;
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
public class DogBreedService {

    private final DogBreedRepository dogBreedRepository;
    private final DogBreedRest dogBreedRest;

    @Autowired
    public DogBreedService(DogBreedRepository dogBreedRepository, DogBreedRest dogBreedRest) {
        this.dogBreedRepository = dogBreedRepository;
        this.dogBreedRest = dogBreedRest;
    }

    public DogBreed addDogBreedInitialize(DogBreed dogBreed) {
        return dogBreedRepository.save(dogBreed);
    }

    public void addDogBreed(DogBreed dogBreed) {
        dogBreedRepository.save(dogBreed);
        dogBreedRest.create(dogBreed, dogBreed.getUuid());
    }

    public List<DogBreed> getAllDogBreeds() {
        return dogBreedRepository.findAll();
    }

    public Optional<DogBreed> getDogBreedById(UUID id){ return dogBreedRepository.findById(id); }

    public DogBreed updateDogBreed(UUID id, DogBreed updatedDogBreed) {
        DogBreed existingDogBreed = dogBreedRepository.findById(id).orElse(null);
        if (existingDogBreed != null) {
            updatedDogBreed.setUuid(existingDogBreed.getUuid());
            return dogBreedRepository.save(updatedDogBreed);
        } else {
            return null;
        }
    }

    public boolean deleteDogBreed(UUID id) {
        DogBreed existingDogBreed = dogBreedRepository.findById(id).orElse(null);
        if (existingDogBreed != null) {
            dogBreedRepository.delete(existingDogBreed);
            dogBreedRest.delete(id);
            return true;
        } else {
            return false;
        }
    }
}

