package com.workintech.zoo.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j  // Otomatik olarak bir Logger oluşturur.
@ControllerAdvice  // Tüm @Controller sınıfları için global yapılandırma ve hata yönetimi yapmanı sağlar.

public class ZooGlobalExceptionHandler {  // Tüm hataları yakalayan ve loglayan sınıf.
  @ExceptionHandler
  public ResponseEntity<ZooErrorResponse> handleZooException(ZooException ex) {
    ZooErrorResponse response = new ZooErrorResponse();
    response.setMessage(ex.getMessage());
    response.setStatus(ex.getHttpStatus().value());
    response.setTimestamp(System.currentTimeMillis());

    log.error("ZooException occurred: {}", ex.getMessage());
    return new ResponseEntity<>(response, ex.getHttpStatus());
  }

  @ExceptionHandler
  public ResponseEntity<ZooErrorResponse> handleGenericException(Exception ex) {
    ZooErrorResponse response = new ZooErrorResponse();
    response.setMessage("Unexpected error: " + ex.getMessage());
    response.setStatus(500);
    response.setTimestamp(System.currentTimeMillis());

    log.error("Unhandled exception: {}", ex.getMessage(), ex);
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
