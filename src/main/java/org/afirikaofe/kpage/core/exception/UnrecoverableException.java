package org.afirikaofe.kpage.core.exception;

public class UnrecoverableException extends RuntimeException {

    public UnrecoverableException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnrecoverableException(String message) {
        super(message);
    }
}
