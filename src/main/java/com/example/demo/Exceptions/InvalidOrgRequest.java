package com.example.demo.Exceptions;

public class InvalidOrgRequest extends RuntimeException{
    public InvalidOrgRequest(String s){
        super(s);
    }
}
