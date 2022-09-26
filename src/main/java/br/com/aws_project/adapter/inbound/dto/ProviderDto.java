package br.com.aws_project.adapter.inbound.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProviderDto {

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
