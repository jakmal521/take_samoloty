package pl.polsl.airlines.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalResponseException {
  @ExceptionHandler(ResourceNotFoundException.class)
  public void handle(){}
}
