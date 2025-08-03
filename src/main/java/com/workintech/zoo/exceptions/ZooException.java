package com.workintech.zoo.exceptions;

import org.springframework.http.HttpStatus;

public class ZooException extends RuntimeException {  // Uygulama içi özel hata sınıfı.

  private HttpStatus status;

  public ZooException(String message) {
    super(message);
    this.status = HttpStatus.INTERNAL_SERVER_ERROR;
  }

  public ZooException(String message, HttpStatus status) {
    super(message);
    this.status = status;
  }

  public HttpStatus getHttpStatus() {
    return status;
  }

  public void setHttpStatus(HttpStatus status) {
    this.status = status;
  }
}
