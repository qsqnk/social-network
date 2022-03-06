package com.socialnetwork.exceptions;

public class UserAlreadyExistsException extends Exception {
  public UserAlreadyExistsException(String username) {
    super("User " + username + " is already registered!");
  }
}
