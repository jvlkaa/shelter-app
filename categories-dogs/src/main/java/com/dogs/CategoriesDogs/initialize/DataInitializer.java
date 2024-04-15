package com.dogs.CategoriesDogs.initialize;

import com.dogs.CategoriesDogs.DogBreed;
import com.dogs.CategoriesDogs.service.DogBreedService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class DataInitializer {
    private final DogBreedService dogBreedService;

    @Autowired
    public DataInitializer(DogBreedService dogBreedService) {
        this.dogBreedService = dogBreedService;
    }

    @PostConstruct
    public void initialize() {
        DogBreed dogBreed1 = DogBreed.builder()
                .uuid(UUID.fromString("23d9bfc5-a329-4053-b105-89bd903953e7"))
                .name("Buldog")
                .height(30)
                .build();
        dogBreedService.addDogBreedInitialize(dogBreed1);

        DogBreed dogBreed2 = DogBreed.builder()
                .uuid(UUID.fromString("c2e57ca3-b1a9-4245-845a-29126c8239b4"))
                .name("Chihuahua")
                .height(20)
                .build();
        dogBreedService.addDogBreedInitialize(dogBreed2);

        DogBreed dogBreed3 = DogBreed.builder()
                .uuid(UUID.fromString("76740f19-4409-492a-9bc5-e2879a788df0"))
                .name("York")
                .height(17)
                .build();
        dogBreedService.addDogBreedInitialize(dogBreed3);

        DogBreed dogBreed4 = DogBreed.builder()
                .uuid(UUID.fromString("19930e09-9f52-494b-ae27-16f72668cbde"))
                .name("Labrador")
                .height(60)
                .build();
        dogBreedService.addDogBreedInitialize(dogBreed4);
    }
}
