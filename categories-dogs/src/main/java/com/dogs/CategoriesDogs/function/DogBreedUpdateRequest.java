package com.dogs.CategoriesDogs.function;

import com.dogs.CategoriesDogs.dto.UpdateBreed;
import com.dogs.CategoriesDogs.DogBreed;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class DogBreedUpdateRequest  implements BiFunction<DogBreed, UpdateBreed, DogBreed> {
    @Override
    public DogBreed apply(DogBreed breed, UpdateBreed updated_breed) {
        return DogBreed.builder()
                .uuid(breed.getUuid())
                .name(updated_breed.getName())
                .height(updated_breed.getHeight())
                //.pets(breed.getPets())
                .build();
    }
}