package com.carboard.center.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundDataWithId.class)
    public ResponseEntity<Object> handleNotDataWithId() {
        logger.info("call handleNotDataWithId");
        return ResponseEntity.noContent().build();
    }
}
