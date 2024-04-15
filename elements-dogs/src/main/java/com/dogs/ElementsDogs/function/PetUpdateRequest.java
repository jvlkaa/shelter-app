package com.dogs.ElementsDogs.function;
import com.dogs.ElementsDogs.dto.UpdatePet;
import com.dogs.ElementsDogs.Pet;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class PetUpdateRequest  implements BiFunction<Pet, UpdatePet, Pet> {
    @Override
    public Pet apply(Pet pet, UpdatePet updated_pet) {
        return Pet.builder()
                .uuid(pet.getUuid())
                .name(updated_pet.getName())
                .age(updated_pet.getAge())
                .breed(pet.getBreed())
                .build();
    }
}
