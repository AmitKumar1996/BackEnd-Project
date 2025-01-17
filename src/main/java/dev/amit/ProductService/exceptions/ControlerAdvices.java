package dev.amit.ProductService.exceptions;

import dev.amit.ProductService.dtos.ExceptionDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
// Jb bhi controller apna kam khatam karta hai to jo kuch bhi vo return karta hai vo Advices hoto huye jata hai agar exceptions aata hai to usi me handel hao jata hai
@Data
@ControllerAdvice
public class ControlerAdvices {

//    @ExceptionHandler(NotFoundException.class)
//    private ResponseEntity<ExceptionDto> handelNotFoundException(NotFoundException notFoundException) {
//        // System.out.println("Not found Exception Happend");
//
//        return new ResponseEntity(new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()), HttpStatus.NOT_FOUND);
//
//
//    }
//
//
//    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
//    private ResponseEntity<ExceptionDto> handelArrayIndexOutOfBoundsException(
//            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException
//    ) {
//        // System.out.println("Not found Exception Happend");
//
//        return new ResponseEntity(new ExceptionDto(HttpStatus.NOT_FOUND, arrayIndexOutOfBoundsException.getMessage()), HttpStatus.NOT_FOUND);
//
//
//    }


//    @ExceptionHandler(Exception.class)
//    private ResponseEntity<ExceptionDto> handelGlobalExceptions(Exception exception) {
//        // System.out.println("Not found Exception Happend");
//
//        return new ResponseEntity(new ExceptionDto(HttpStatus.NOT_FOUND, Exception.class), HttpStatus.NOT_FOUND);
//
//
//    }
}
