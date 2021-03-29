package no.itera.assignment.controller.advice;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleRuntimeException(Exception exception) {
        log.error("Exception occured", exception);
        return ResponseEntity.badRequest().contentType(MediaType.TEXT_PLAIN).body(exception.getMessage());
    }
}
