package com.carboard.center.exception;

import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    private Map<ErrorType, Error> cachedError = new HashMap<>();

    // 변수 없는 에러 타입은 캐싱해서 사용한다.
    {
        cachedError.put(ErrorType.UNKNOWN, new Error(ErrorType.UNKNOWN, "unknown exception"));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity handleNoDataFoundException(NoDataFoundException noDataFound) {
        String id = noDataFound.getMessage();
        Error error = new Error(ErrorType.NO_DATA_FOUND, "no data found exception with %s", id);
        System.out.println(System.identityHashCode(error));
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleUnknownException() {
        return ResponseEntity.internalServerError().body(cachedError.get(ErrorType.UNKNOWN));
    }

    @Getter
    private static class Error {
         private ErrorType errorType;
         private String msg;
         private LocalDateTime errorTime = LocalDateTime.now();

         public Error(ErrorType errorType, String msg, Object ...args) {
             this.errorType = errorType;
             this.msg = String.format(msg, args);
         }
    }

    private enum ErrorType {
        NO_DATA_FOUND,
        UNKNOWN
        ;
    }
}
