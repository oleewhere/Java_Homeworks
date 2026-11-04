package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    private String id;

    private String model;
    private String producer;
    private Integer power;
    private String photo;
}