package dev.amit.ProductService.dtos;

import org.springframework.http.HttpStatus;


public class ExceptionDto {
    private HttpStatus errorCode;
    private String message;

    public void ExceptionDato(HttpStatus status, String message){

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
