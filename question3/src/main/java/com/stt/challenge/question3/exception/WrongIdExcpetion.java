package com.stt.challenge.question3.exception;

public class WrongIdExcpetion extends Exception {

    public WrongIdExcpetion() {
    }

    public WrongIdExcpetion(String message) {
        super(message);
    }

    public WrongIdExcpetion(Throwable cause) {
        super(cause);
    }

    public WrongIdExcpetion(String message, Throwable cause) {
        super(message, cause);
    }
}
