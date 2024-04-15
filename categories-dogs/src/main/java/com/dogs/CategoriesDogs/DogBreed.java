package com.dogs.CategoriesDogs;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.UUID;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "dog_breeds")
public class DogBreed implements Comparable<DogBreed>, Serializable {
    @Id
    private UUID uuid;
    String name;
    int height;

    static final long serialVersionUID = 13;

    public DogBreed() {}

    public DogBreed(UUID uuid, String name, int height) {
        this.uuid = uuid;
        this.name = name;
        this.height = height;
       // this.pets = pets;
    }

    @Override
    public int compareTo(DogBreed other) {
        int i = name.compareTo(other.name);
        if (i == 0) {
            i = height - other.height;
        }
        return i;
    }

    @Override
    public String toString() {
        return "Breed: "  + name + ", height: " + height + "    ID: " + uuid;
    }

    //public void addPet(Pet pet){
    //    pets.add(pet);
    //}
}

