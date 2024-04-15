package com.dogs.ElementsDogs.breed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DogBreedRepository extends JpaRepository<DogBreed, UUID> {
}
