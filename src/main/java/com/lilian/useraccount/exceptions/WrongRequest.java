package com.lilian.useraccount.exceptions;

public class WrongRequest extends RuntimeException{

    public WrongRequest(String message) {
        super(message);
    }

}
