package br.com.aws_project.applications.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
@With
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    private String _id;

    private String id;

    private String name;

    private String cpf;

    private String email;
}
