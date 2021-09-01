package com.example.marathon.exceptionhandlers;

import com.example.marathon.exceptions.CartNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CartControllerExceptionHandler {


      @ExceptionHandler(value = CartNotFoundException.class )
     public ResponseEntity handlerCartNotFoundException(){

         return new ResponseEntity("Cart id invalid", HttpStatus.BAD_REQUEST);
     }

}
