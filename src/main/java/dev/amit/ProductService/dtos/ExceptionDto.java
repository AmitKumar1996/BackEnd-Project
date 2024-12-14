package dev.amit.ProductService.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor

public class ExceptionDto {
    private HttpStatus errorCode;
    private String message;


    // constructor
    public ExceptionDto(HttpStatus errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public void ExceptionDato(HttpStatus status, String message) {
        this.errorCode = status;
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }
}
