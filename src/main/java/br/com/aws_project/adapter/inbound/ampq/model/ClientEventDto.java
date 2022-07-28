package br.com.aws_project.adapter.inbound.ampq.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientEventDto {

    private String id;
    private String name;

}
