package com.dogs.ElementsDogs.function;

import com.dogs.ElementsDogs.dto.PutPet;
import com.dogs.ElementsDogs.breed.DogBreed;
import com.dogs.ElementsDogs.Pet;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class PetRequest  implements BiFunction<UUID, PutPet, Pet> {
    //BiFunction<A, B, C> -> C apply(A a, B b)
    @Override
    public Pet apply(UUID id, PutPet created_breed) {
        return Pet.builder()
                .uuid(id)
                .name(created_breed.getName())
                .age(created_breed.getAge())
                .breed(DogBreed.builder()
                        .uuid(created_breed.getBreed())
                        .build())
                .build();
    }
}
