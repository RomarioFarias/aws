package br.com.aws_project.applications.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
@With
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String _id;

    private String id;

    private String name;

    private String description;

    private Double value;

    private String providerId;

    private Integer amount;
}
