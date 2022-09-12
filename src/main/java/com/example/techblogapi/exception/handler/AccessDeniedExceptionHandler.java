package com.example.techblogapi.exception.handler;

import com.example.techblogapi.exception.AccessDeniedException;
import com.example.techblogapi.exception.ErrorBody;
import com.example.techblogapi.exception.RestExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccessDeniedExceptionHandler extends ResponseEntityExceptionHandler implements RestExceptionHandler<AccessDeniedException> {


    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handle(AccessDeniedException ex) {

        List<String> Error=new ArrayList<>();
        Error.add(ex.getMessage());
        ErrorBody errorBody = new ErrorBody();
        errorBody.setMessage(Error);
        errorBody.setStatus(HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(errorBody,HttpStatus.UNAUTHORIZED);
    }
}
