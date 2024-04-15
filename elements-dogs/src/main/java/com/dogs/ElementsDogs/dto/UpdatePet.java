package com.dogs.ElementsDogs.dto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class UpdatePet {
    private String name;
    private int age;
}
