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
public class PutPet {
    private String name;
    private int age;
    private UUID breed;
}
