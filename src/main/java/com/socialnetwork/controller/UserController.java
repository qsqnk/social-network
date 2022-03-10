package com.socialnetwork.controller;

import com.socialnetwork.entity.MessageEntity;
import com.socialnetwork.entity.UserEntity;
import com.socialnetwork.exceptions.NoSuchUserException;
import com.socialnetwork.exceptions.UserAlreadyRegisteredException;
import com.socialnetwork.service.MessageService;
import com.socialnetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

  private final UserService userService;
  private final MessageService messageService;

  @Autowired
  public UserController(UserService userService, MessageService messageService) {
    this.userService = userService;
    this.messageService = messageService;
  }

  @PostMapping("register")
  public ResponseEntity<String> registerUser(@RequestBody UserEntity user) {
    var username = user.getUsername();
    try {
      userService.register(user);
      return ResponseEntity.ok("User " + username + " is registered!");
    } catch (UserAlreadyRegisteredException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Unhandled error");
    }
  }

  @PostMapping("messages")
  public ResponseEntity<String> processMessage(@RequestBody MessageEntity message) {
    try {
      messageService.process(message);
      var senderId = message.getSenderId();
      var receiverId = message.getReceiverId();
      return ResponseEntity.ok(
          String.format("Message from %d to %d delivered", senderId, receiverId));
    } catch (NoSuchUserException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Unhandled error");
    }
  }
}
