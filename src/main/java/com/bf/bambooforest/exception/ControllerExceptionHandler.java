package com.bf.bambooforest.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponseDto> handleCustomException(final CustomException e){
        ErrorResponseDto responseDto = ErrorResponseDto
                .builder()
                .status(e.getErrorCode().getStatus())
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(e.getErrorCode().getStatus()).body(responseDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValidException(final MethodArgumentNotValidException e){
        ErrorResponseDto responseDto = ErrorResponseDto
                .builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(e.getFieldError().getField() + ": " + e.getFieldError().getDefaultMessage())
                .build();
        return ResponseEntity.status(responseDto.getStatus()).body(responseDto);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ErrorResponseDto> handleConstraintViolationException(final ConstraintViolationException e){
        ErrorResponseDto responseDto = ErrorResponseDto
                .builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(responseDto.getStatus()).body(responseDto);
    }
}
