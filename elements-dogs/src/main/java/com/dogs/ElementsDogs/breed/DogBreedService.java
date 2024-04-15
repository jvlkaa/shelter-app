package com.dogs.ElementsDogs.breed;

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

    @Autowired
    public DogBreedService(DogBreedRepository dogBreedRepository) {
        this.dogBreedRepository = dogBreedRepository;
    }

    public DogBreed addDogBreed(DogBreed dogBreed) {
        return dogBreedRepository.save(dogBreed);
    }

    public Optional<DogBreed> getDogBreedById(UUID id){ return dogBreedRepository.findById(id); }

    public boolean deleteDogBreed(UUID id) {
        DogBreed existingDogBreed = dogBreedRepository.findById(id).orElse(null);
        if (existingDogBreed != null) {
            dogBreedRepository.delete(existingDogBreed);
            return true;
        } else {
            return false;
        }
    }
}

