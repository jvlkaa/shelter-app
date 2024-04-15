package com.dogs.CategoriesDogs.repository;

import com.dogs.CategoriesDogs.DogBreed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DogBreedRepository extends JpaRepository<DogBreed, UUID> {
    DogBreed findByName(String name);
}
