package com.dogs.CategoriesDogs.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UpdateBreed{
    private String name;
    private int height;
}
