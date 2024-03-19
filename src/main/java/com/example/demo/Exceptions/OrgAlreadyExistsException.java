package com.example.demo.Exceptions;

public class OrgAlreadyExistsException extends RuntimeException {
    public OrgAlreadyExistsException(String s) {
        super(s);
    }
}
