package com.rest.multimoduleproject.exception;

public class CUserSigninFailedException extends RuntimeException {
    public CUserSigninFailedException(String msg, Throwable t) {
        super(msg, t);
    }
    public CUserSigninFailedException(String msg) {
        super(msg);
    }
    public CUserSigninFailedException() {
        super();
    }
}
