package br.com.aws_project.adapter.inbound.dto;

import lombok.*;

@With
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorData {
//  @Schema(description = "Attribute error name")
  private String field;

//  @Schema(description = "Description of the error for that attribute")
  private String message;

//  @Schema(description = "Received value")
  private Object value;
}
