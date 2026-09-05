package com.travelapp.travel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex){
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    /*ResponseEntity a response wrapper that makes you able to put your own HTTP status code,
    meaning status + body together
     */

    @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleGeneral(Exception ex){
        return ResponseEntity.status(500).body("Something went wrong");
    }
    /*generic and catches any unexpected exceptions, yes the "something went wrong"
    can be annoying as the user won't understand the exact error but its kept that way for security reasons,
    as showing the real error message could expose sensitive data or internal system details
     */

    







}
