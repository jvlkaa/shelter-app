package com.dogs.ElementsDogs.repository;
import com.dogs.ElementsDogs.breed.DogBreed;
import com.dogs.ElementsDogs.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PetRepository extends JpaRepository<Pet, UUID> {

    Pet findByName(String name);

    List<Pet> findAllByBreed(DogBreed dogBreed);

}