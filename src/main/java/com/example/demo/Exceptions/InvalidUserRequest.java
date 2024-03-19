package com.example.demo.Exceptions;

public class InvalidUserRequest extends RuntimeException{
    public InvalidUserRequest(String s){
        super(s);
    }
}
