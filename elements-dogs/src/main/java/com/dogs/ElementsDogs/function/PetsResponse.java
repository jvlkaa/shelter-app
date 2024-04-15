package com.dogs.ElementsDogs.function;

import com.dogs.ElementsDogs.dto.GetPets;
import com.dogs.ElementsDogs.Pet;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class PetsResponse implements Function<List<Pet>, GetPets>{

    @Override
    public GetPets apply(List<Pet> pets) {
        return GetPets.builder()
                .pets(pets.stream()
                        .map(pet -> GetPets.Pet.builder()
                                .uuid(pet.getUuid())
                                .name(pet.getName())
                                .build())
                        .toList())
                .build();
    }

}
