package br.com.aws_project.applications.exception;

import br.com.aws_project.applications.enumeration.ExceptionCode;
import br.com.aws_project.adapter.inbound.dto.ErrorDto;
import org.springframework.http.HttpStatus;

import java.util.List;

public class BusinessException extends RuntimeException {

    private final ExceptionCode code;
    private  final static HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
    private String[] customMessageFields = new String[1];
    private List<ErrorDto> details;

    public BusinessException(String message, ExceptionCode code, String... customMessageFields) {
        super(message);
        this.code = code;
        this.customMessageFields = customMessageFields;
    }

    public BusinessException(ExceptionCode code) {
        this.code = code;
    }

    public BusinessException(ExceptionCode code, List<ErrorDto> details) {
        this.code = code;
        this.details = details;
       // this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public BusinessException(ExceptionCode code, String... customMessageFields) {
        super("Business exception");
        this.code = code;
        this.customMessageFields = customMessageFields;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getCodeAsString() {
        return code.toString();
    }
    
    public String[] getArgs() {
        return customMessageFields;
    }
}
