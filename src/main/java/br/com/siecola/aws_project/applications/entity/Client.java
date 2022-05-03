package br.com.siecola.aws_project.applications.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
public class Client {
    @Id
    String id;

    String name;

    String cpf;

    String email;
}
