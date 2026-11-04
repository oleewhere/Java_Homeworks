package org.example.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CarRequestDto {

    @NotBlank(message = "Model cannot be blank")
    private String model;

    @NotBlank(message = "Producer cannot be blank")
    private String producer;

    @NotNull(message = "Power cannot be null")
    @Min(value = 1, message = "Power must be greater than 0")
    private Integer power;
}