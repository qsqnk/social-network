package com.socialnetwork.controller;

import com.socialnetwork.entity.UserEntity;
import com.socialnetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("register")
  public ResponseEntity<?> registerUser(@RequestBody UserEntity user) {
    var username = user.getUsername();
    try {
      userService.register(user);
      return ResponseEntity.ok("User " + username + " is registered!");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
