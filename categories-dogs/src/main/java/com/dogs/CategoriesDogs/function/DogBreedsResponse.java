package com.dogs.CategoriesDogs.function;

import com.dogs.CategoriesDogs.dto.GetDogBreeds;
import com.dogs.CategoriesDogs.DogBreed;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class DogBreedsResponse implements Function<List<DogBreed>, GetDogBreeds> {
    //Function<A, B> -> B apply A
    @Override
    public GetDogBreeds apply(List<DogBreed> breeds) {
        return GetDogBreeds.builder()
                .breeds(breeds.stream()
                        .map(breed -> GetDogBreeds.DogBreed.builder()
                                .uuid(breed.getUuid())
                                .name(breed.getName())
                                .height(breed.getHeight())
                                .build())
                        .toList())
                .build();
    }
}
