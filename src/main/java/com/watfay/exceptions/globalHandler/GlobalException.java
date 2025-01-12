package com.watfay.exceptions.globalHandler;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import com.watfay.exceptions.AlreadyExistException;
import com.watfay.exceptions.BadCredentialException;
import com.watfay.exceptions.BadRequestException;
import com.watfay.exceptions.NotFoundException;
import com.watfay.exceptions.exceptionResponse.ExceptionResponse;
import jakarta.validation.ConstraintViolationException;
import java.nio.file.AccessDeniedException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
    List<String> errors = e
        .getBindingResult()
        .getFieldErrors()
        .stream()
        .map(DefaultMessageSourceResolvable::getDefaultMessage)
        .toList();
    return ExceptionResponse
        .builder()
        .message(errors.toString())
        .status(HttpStatus.BAD_REQUEST)
        .className(e.getClass().getSimpleName())
        .build();
  }

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse handleConstraintViolation(ConstraintViolationException e) {
    return ExceptionResponse
        .builder()
        .message(e.getMessage())
        .status(HttpStatus.BAD_REQUEST)
        .className(e.getClass().getSimpleName())
        .build();
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ExceptionResponse handleNotFound(NotFoundException e) {
    return ExceptionResponse
        .builder()
        .message(e.getMessage())
        .status(HttpStatus.NOT_FOUND)
        .className(e.getClass().getSimpleName())
        .build();
  }

  @ExceptionHandler(AlreadyExistException.class)
  @ResponseStatus(HttpStatus.FOUND)
  public ExceptionResponse handleAlreadyExist(AlreadyExistException e) {
    return ExceptionResponse
        .builder()
        .message(e.getMessage())
        .status(HttpStatus.FOUND)
        .className(e.getClass().getSimpleName())
        .build();
  }

  @ExceptionHandler(BadCredentialException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse handleBadCredential(BadCredentialException e) {
    return ExceptionResponse
        .builder()
        .message(e.getMessage())
        .status(HttpStatus.BAD_REQUEST)
        .className(e.getClass().getSimpleName())
        .build();
  }

  @ExceptionHandler(BadRequestException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse handleBadCredential(BadRequestException e) {
    return ExceptionResponse
        .builder()
        .message(e.getMessage())
        .status(HttpStatus.BAD_REQUEST)
        .className(e.getClass().getSimpleName())
        .build();
  }

  @ExceptionHandler(AccessDeniedException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public ExceptionResponse handleAccessDenied(AccessDeniedException e) {
    return ExceptionResponse
        .builder()
        .message(e.getMessage())
        .status(HttpStatus.FORBIDDEN)
        .className(e.getClass().getSimpleName())
        .build();
  }
}
