package com.dogs.CategoriesDogs.dto;

//import com.example.labSpring.entity.Pet;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PutDogBreed {
    private String name;
    private int height;
}
