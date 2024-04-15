package com.dogs.CategoriesDogs.function;

import com.dogs.CategoriesDogs.dto.GetDogBreed;
import com.dogs.CategoriesDogs.DogBreed;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DogBreedResponse implements Function<DogBreed, GetDogBreed> {
    @Override
    public GetDogBreed apply(DogBreed entity) {
        return GetDogBreed.builder()
                .uuid(entity.getUuid())
                .name(entity.getName())
                .height(entity.getHeight())
                .build();
    }
}
