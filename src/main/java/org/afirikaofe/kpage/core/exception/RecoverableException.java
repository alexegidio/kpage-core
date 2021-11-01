package org.afirikaofe.kpage.core.exception;

public class RecoverableException extends RuntimeException{

    public RecoverableException(String message, Throwable cause) {
        super(message, cause);
    }
}
