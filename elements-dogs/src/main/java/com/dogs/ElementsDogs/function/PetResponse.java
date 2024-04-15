package com.dogs.ElementsDogs.function;

import com.dogs.ElementsDogs.dto.GetPet;
import com.dogs.ElementsDogs.Pet;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PetResponse implements Function<Pet, GetPet> {

    @Override
    public GetPet apply(Pet pet) {
        return GetPet.builder()
                .uuid(pet.getUuid())
                .name(pet.getName())
                .age(pet.getAge())
                .breed(GetPet.DogBreed.builder()
                        .uuid(pet.getBreed().getUuid())
                        .build())
                .build();
    }
}
