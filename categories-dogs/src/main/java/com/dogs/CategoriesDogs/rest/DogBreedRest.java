package com.dogs.CategoriesDogs.rest;
import com.dogs.CategoriesDogs.DogBreed;
import com.dogs.CategoriesDogs.dto.PutDogBreed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class DogBreedRest{

    private final RestTemplate restTemplate;

    @Autowired
    public DogBreedRest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void delete(UUID id) {
        restTemplate.delete("/dogs/breeds/{uuid}", id);
    }

    public void create(DogBreed breed, UUID uuid) {
        restTemplate.put("/dogs/breeds/{uuid}", breed, uuid);
    }
}

