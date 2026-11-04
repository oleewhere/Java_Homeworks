package org.example.dto;

import lombok.Data;

@Data
public class CarFullDto {
    private String id;
    private String model;
    private String producer;
    private Integer power;
    private String photo;
}