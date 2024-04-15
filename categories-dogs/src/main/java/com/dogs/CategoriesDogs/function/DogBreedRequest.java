package com.dogs.CategoriesDogs.function;

import com.dogs.CategoriesDogs.dto.PutDogBreed;
import com.dogs.CategoriesDogs.DogBreed;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class DogBreedRequest  implements BiFunction<UUID, PutDogBreed, DogBreed> {
    //BiFunction<A, B, C> -> C apply(A a, B b)
    @Override
    public DogBreed apply(UUID id, PutDogBreed created_breed) {
        return DogBreed.builder()
                .uuid(id)
                .name(created_breed.getName())
                .height(created_breed.getHeight())
                .build();
    }
}

