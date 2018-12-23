
package com.techdisqus.exception;

/**
 * Exception class thrown for validation errors
 */
public class ValidationException extends RuntimeException {
    public ValidationException(String message){
        super(message);
    }
}
