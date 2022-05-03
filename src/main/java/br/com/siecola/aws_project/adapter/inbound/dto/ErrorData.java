package br.com.siecola.aws_project.adapter.inbound.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

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
