package com.dogs.ElementsDogs.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetPet {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    public static class DogBreed {
        private UUID uuid;
    }

    private UUID uuid;
    private String name;
    private int age;
    private DogBreed breed;
}
