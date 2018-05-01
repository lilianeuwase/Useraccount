package com.lilian.useraccount.handlers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lilian.useraccount.exceptions.WrongRequest;
import com.lilian.useraccount.reponses.Response1;



@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity notFoundHandler(Exception ex) {
        return ResponseEntity.status(404).body(Response1.builder()
                .error(404).status("NOT FOUND").message(ex.getMessage()).build());
    }


    @ExceptionHandler({WrongRequest.class})
    public ResponseEntity unprocessableEntityHandler(Exception ex) {
        return ResponseEntity.status(422).body(Response1.builder()
                .error(422).status("UNPROCESSABLE ENTITY").message(ex.getMessage()).build());
    }

}
