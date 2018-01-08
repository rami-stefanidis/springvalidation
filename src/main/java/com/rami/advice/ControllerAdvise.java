package com.rami.advice;

import com.rami.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler({ MyException.class })
    public ResponseEntity<String> error() {
        LOG.info("In advise");
        return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
    }
}
