package com.dogs.ElementsDogs.dto;

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
public class GetPets {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    public static class Pet {
        private UUID uuid;
        private String name;
    }

    @Singular
    private List<Pet> pets;

}
