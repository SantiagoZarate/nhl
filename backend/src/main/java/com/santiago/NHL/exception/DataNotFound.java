package com.santiago.NHL.exception;

import jakarta.persistence.EntityNotFoundException;

public class DataNotFound extends EntityNotFoundException {
  public DataNotFound(String message) {
    super(message);
  }
}
