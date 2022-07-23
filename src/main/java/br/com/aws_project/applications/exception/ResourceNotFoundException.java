package br.com.aws_project.applications.exception;

import br.com.aws_project.adapter.inbound.dto.ErrorDto;
import br.com.aws_project.applications.enumeration.ExceptionCode;
import java.util.List;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BusinessException {
    private HttpStatus httpStatus = HttpStatus.NOT_FOUND;

    public ResourceNotFoundException(ExceptionCode code) {
        super(code);
    }

    public ResourceNotFoundException(ExceptionCode code, String... customMessageFields) {
        super(code, customMessageFields);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
