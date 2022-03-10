package com.socialnetwork.exceptions;

public class UserAlreadyRegisteredException extends Exception {

  public UserAlreadyRegisteredException(String username) {
    super(String.format("User %s is already registered!", username));
  }

  public UserAlreadyRegisteredException(String username, Throwable cause) {
    super(String.format("User %s is already registered!", username), cause);
  }
}
