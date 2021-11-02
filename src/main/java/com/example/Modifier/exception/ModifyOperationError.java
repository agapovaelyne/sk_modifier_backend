package com.example.Modifier.exception;

public class ModifyOperationError extends RuntimeException {
    public ModifyOperationError(String msg) {
        super(msg);
    }
}
