package org.seguros.exception;

public class CtrlException extends Exception {

    public CtrlException() {
    }

    public CtrlException(String message) {
        super(message);
    }

    public CtrlException(String message, Throwable cause) {
        super(message, cause);
    }

    public CtrlException(Throwable cause) {
        super(cause);
    }

    public CtrlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
