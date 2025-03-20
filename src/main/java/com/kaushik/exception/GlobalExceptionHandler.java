package com.kaushik.exception;

import com.kaushik.payload.response.ExceptionResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> ExceptionHandler(Exception e, WebRequest req){

        ExceptionResponse response = new ExceptionResponse( e.getMessage(),
                req.getDescription(false),
                LocalDateTime.now());

        return ResponseEntity.ok(response);

    }
}
