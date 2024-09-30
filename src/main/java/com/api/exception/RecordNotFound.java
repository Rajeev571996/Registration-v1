package com.api.exception;

public class RecordNotFound  extends RuntimeException{
    public RecordNotFound(String msg) {
        super(msg);
    }
}
