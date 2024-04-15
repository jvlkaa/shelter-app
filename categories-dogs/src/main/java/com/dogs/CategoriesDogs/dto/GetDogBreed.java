package com.dogs.CategoriesDogs.dto;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetDogBreed {

    private UUID uuid;
    private String name;
    private int height;
}
