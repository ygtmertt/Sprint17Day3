package com.workintech.zoo.exceptions;

public class ZooErrorResponse {
  private String message;
  private int status;
  private long timestamp;

  public ZooErrorResponse() {}

  public ZooErrorResponse(String message, int status, long timestamp) {  // Hata mesaının kullanıcıya gösterilme şekli.
    this.message = message;
    this.status = status;
    this.timestamp = timestamp;
  }

  public String getMessage() {
    return message;
  }

  public int getStatus() {
    return status;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }
}
