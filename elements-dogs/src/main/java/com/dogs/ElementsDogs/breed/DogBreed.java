package com.dogs.ElementsDogs.breed;

import com.dogs.ElementsDogs.Pet;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "dog_breeds")
public class DogBreed{
    @Id
    private UUID uuid;

    @OneToMany(mappedBy = "breed", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Pet> pets;

    public DogBreed() {}

    public DogBreed(UUID uuid, List<Pet> pets) {
        this.uuid = uuid;
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Breed: "  + "    ID: " + uuid;
    }

    public void addPet(Pet pet){
        pets.add(pet);
    }
}

