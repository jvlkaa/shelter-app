package com.dogs.ElementsDogs;

import com.dogs.ElementsDogs.breed.DogBreed;
import com.dogs.ElementsDogs.breed.DogBreedService;
import com.dogs.ElementsDogs.service.PetService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class DataInitializer {
    private final DogBreedService dogBreedService;
    private final PetService petService;

    @Autowired
    public DataInitializer(DogBreedService dogBreedService, PetService petService) {
        this.dogBreedService = dogBreedService;
        this.petService = petService;
    }

    @PostConstruct
    public void initialize() {
        DogBreed dogBreed1 = DogBreed.builder()
                .uuid(UUID.fromString("23d9bfc5-a329-4053-b105-89bd903953e7"))
                .pets(new ArrayList<>())
                .build();
        dogBreedService.addDogBreed(dogBreed1);

        DogBreed dogBreed2 = DogBreed.builder()
                .uuid(UUID.fromString("c2e57ca3-b1a9-4245-845a-29126c8239b4"))
                .pets(new ArrayList<>())
                .build();
        dogBreedService.addDogBreed(dogBreed2);

        DogBreed dogBreed3 = DogBreed.builder()
                .uuid(UUID.fromString("76740f19-4409-492a-9bc5-e2879a788df0"))
                .pets(new ArrayList<>())
                .build();
        dogBreedService.addDogBreed(dogBreed3);

        DogBreed dogBreed4 = DogBreed.builder()
                .uuid(UUID.fromString("19930e09-9f52-494b-ae27-16f72668cbde"))
                .pets(new ArrayList<>())
                .build();
        dogBreedService.addDogBreed(dogBreed4);

        Pet pet1 = Pet.builder()
                .uuid(UUID.fromString("b5aa9e6a-06fb-4251-92f4-1fbec7b086d9"))
                .name("Paris")
                .age(9)
                .breed(dogBreed2)
                .build();
        petService.addPet(pet1);
        Pet pet2 = Pet.builder()
                .uuid(UUID.randomUUID())
                .name("Nicki")
                .age(3)
                .breed(dogBreed2)
                .build();
        petService.addPet(pet2);

        Pet pet3 = Pet.builder()
                .uuid(UUID.randomUUID())
                .name("Daisy")
                .age(13)
                .breed(dogBreed2)
                .build();
        petService.addPet(pet3);

        Pet pet4 = Pet.builder()
                .uuid(UUID.randomUUID())
                .name("Rose")
                .age(2)
                .breed(dogBreed1)
                .build();
        petService.addPet(pet4);

        Pet pet5 = Pet.builder()
                .uuid(UUID.randomUUID())
                .name("Bella")
                .age(6)
                .breed(dogBreed1)
                .build();
        petService.addPet(pet5);

        Pet pet6 = Pet.builder()
                .uuid(UUID.fromString("ba7bb36a-04fc-4657-01a7-3dbdc1b684d2"))
                .name("Gigi")
                .age(12)
                .breed(dogBreed2)
                .build();
        petService.addPet(pet6);

        Pet pet7 = Pet.builder()
                .uuid(UUID.randomUUID())
                .name("Lola")
                .age(6)
                .breed(dogBreed4)
                .build();
        petService.addPet(pet7);
    }
}
