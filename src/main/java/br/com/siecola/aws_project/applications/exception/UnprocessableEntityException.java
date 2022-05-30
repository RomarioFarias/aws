package br.com.siecola.aws_project.applications.exception;

import br.com.siecola.aws_project.adapter.inbound.dto.ErrorDto;
import br.com.siecola.aws_project.applications.enumeration.ExceptionCode;

import java.util.List;

public class UnprocessableEntityException extends BusinessException {
    public UnprocessableEntityException(String message, ExceptionCode code, String... customMessageFields) {
        super(message, code, customMessageFields);
    }

    public UnprocessableEntityException(ExceptionCode code) {
        super(code);
    }

    public UnprocessableEntityException(ExceptionCode code, List<ErrorDto> details) {
        super(code, details);
    }

    public UnprocessableEntityException(ExceptionCode code, String... customMessageFields) {
        super(code, customMessageFields);
    }
}
