package com.socialnetwork.exceptions;

public class NoSuchUserException extends Exception {

  public NoSuchUserException(Long id) {
    super(String.format("User %d does not exist", id));
  }

  public NoSuchUserException(Long id, Throwable cause) {
    super(String.format("User %d does not exist", id), cause);
  }
}
