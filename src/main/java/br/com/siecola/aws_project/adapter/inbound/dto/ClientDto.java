package br.com.siecola.aws_project.adapter.inbound.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class ClientDto {

    private String id;

  //  @NotEmpty(message = "{email.notempty}")
    private String name;

    @CPF
   // @NotBlank
    private String cpf;

//    @Email
//    @NotEmpty
    private String email;
}
