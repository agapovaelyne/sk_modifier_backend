package com.example.Modifier.dto;

import lombok.*;

import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncreaseRequestDTO {

    @Positive(message = "id: positive number required")
    @Getter
    private int id;

    @Getter
    @Setter
    private int add;
}
