package com.growit.app.common.exception;

import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import com.growit.app.common.dto.BaseErrorResponse;
import java.lang.reflect.MalformedParametersException;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({
    BadRequestException.class,
    MalformedParametersException.class,
    IllegalArgumentException.class,
    ValueInstantiationException.class,
  })
  public ResponseEntity<BaseErrorResponse> returnBadRequestException(RuntimeException e) {
    return ResponseEntity.badRequest()
        .body(
            BaseErrorResponse.builder().message("입력한 정보가 올바르지 않습니다. \n" + e.getMessage()).build());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<BaseErrorResponse> handleException(Exception e) {
    return ResponseEntity.internalServerError()
        .body(BaseErrorResponse.builder().message(e.getMessage()).build());
  }

  @ExceptionHandler({NotFoundException.class})
  public ResponseEntity<BaseErrorResponse> handleNotFoundException(BaseException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(BaseErrorResponse.builder().message(e.getMessage()).build());
  }

  @ExceptionHandler({NoResourceFoundException.class})
  public ResponseEntity<BaseErrorResponse> handleNoResourceFoundException(
      NoResourceFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(BaseErrorResponse.builder().message(e.getMessage()).build());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, List<String>>> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
    List<String> messages =
        ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
    Map<String, List<String>> body = Map.of("message", messages);
    return ResponseEntity.badRequest().body(body);
  }
}
