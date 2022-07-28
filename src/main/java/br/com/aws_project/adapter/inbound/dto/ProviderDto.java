package br.com.aws_project.adapter.inbound.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ProviderDto {
    @Id
    private String _id;

    private String id;

    private String name;

    private String cpf;

    private String email;
}
