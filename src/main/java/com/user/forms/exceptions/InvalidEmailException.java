package com.user.forms.exceptions;



import java.time.LocalDateTime;

public class InvalidEmailException extends RuntimeException {
    private LocalDateTime timestamp;

    public InvalidEmailException(String message) {
        super(message);
        this.timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
