package com.carboard.center.exception;

public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException(String id) {
        super(id);
    }

    public NoDataFoundException(Long id) {
        super(id.toString());
    }
}
