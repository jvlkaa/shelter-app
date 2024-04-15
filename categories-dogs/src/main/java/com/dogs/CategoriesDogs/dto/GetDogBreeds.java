package com.dogs.CategoriesDogs.dto;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetDogBreeds {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    public static class DogBreed {
        private UUID uuid;
        private String name;
        private int height;

    }

    @Singular
    private List<DogBreed> breeds;
}
