package com.rbnbproject.rbnbcloneproject.exceptions;

public class EntityNotFoundException extends  RuntimeException{
    public EntityNotFoundException(String message){
        super(message);
    }
}
