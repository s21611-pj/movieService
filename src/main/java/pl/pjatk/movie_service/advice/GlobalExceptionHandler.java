package pl.pjatk.movie_service.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import pl.pjatk.movie_service.model.ErrorModel;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Object> handle_4XX_Exceptions(HttpClientErrorException exception) {
        if (exception.getStatusCode().equals(HttpStatus.NOT_FOUND))
            return new ResponseEntity<>(new ErrorModel(HttpStatus.NOT_FOUND.value(), exception.toString(), Instant.now()), HttpStatus.NOT_FOUND);
        if (exception.getStatusCode().equals(HttpStatus.BAD_REQUEST))
            return new ResponseEntity<>(new ErrorModel(HttpStatus.BAD_REQUEST.value(), exception.toString(), Instant.now()), HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok().build();
    }
}


