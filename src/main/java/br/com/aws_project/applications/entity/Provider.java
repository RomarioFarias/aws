package br.com.aws_project.applications.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@With
@AllArgsConstructor
@NoArgsConstructor
public class Provider {
    @Id
    private String _id;

    private String id;

    private String name;

    private String cpf;

    private String email;
}
