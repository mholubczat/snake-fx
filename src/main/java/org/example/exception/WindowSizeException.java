package org.example.exception;

public class WindowSizeException extends RuntimeException{
    public WindowSizeException(String message) {
        super(message);
    }
}
