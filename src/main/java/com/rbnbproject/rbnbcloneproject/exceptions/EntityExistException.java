package com.rbnbproject.rbnbcloneproject.exceptions;

public class EntityExistException extends RuntimeException{
    public  EntityExistException(String mess){
        super(mess);
    }
}
