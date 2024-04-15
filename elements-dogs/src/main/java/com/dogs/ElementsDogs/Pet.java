package com.dogs.ElementsDogs;

import com.dogs.ElementsDogs.breed.DogBreed;
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
@Table(name = "pets")
public class Pet implements Comparable<Pet>, Serializable {
    @Id
    private UUID uuid;
    String name;
    int age;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    DogBreed breed;
    static final long serialVersionUID = 13;

    public Pet() {}
    public Pet(UUID uuid, String name, int age, DogBreed breed) {
        this.uuid = uuid;
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    @Override
    public int compareTo(Pet other) {
        int i = name.compareTo(other.name);
        if (i == 0) {
            i = age - other.age;
        }
        return i;
    }

    @Override
    public String toString() {
        return "Pet: "  + name + ", age: " + age + "  ID: " + uuid;
    }
}

