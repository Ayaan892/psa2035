package com.crm.exception;

public class ResourceNotFound extends RuntimeException{// making it a child class of runtime ecxeption , bcz this is a runtime ecxeption.
    public ResourceNotFound(String msg) {
        super(msg);
    }
}
