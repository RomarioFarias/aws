package br.com.siecola.aws_project.applications.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

import java.time.Instant;
import java.util.List;

@With
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

//  @Schema(description = "Error description")
  private String message;

//  @Schema(description = "Simple message to identify the problem")
  private String error;

//  @Schema(description = "Http Code")
  private String code;

  private List<ErrorData> details;

//  @Schema(type = "Datetime", description = "Timestamp error")
  private Instant timestamp;
}
