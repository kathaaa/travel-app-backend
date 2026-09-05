package com.travelapp.travel;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
        /*since the runtime exception parent class has a constructor that takes a message
        we replace the message with our own custom exception by calling super
         */
    }
}
