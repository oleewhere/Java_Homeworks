package org.example.dto;

import lombok.Data;

@Data
public class CarFullDto {
    private Long id;
    private String model;
    private String producer;
    private Integer power;
}