package com.socialnetwork.controller;

import com.socialnetwork.entity.MessageEntity;
import com.socialnetwork.exceptions.NoSuchUserException;
import com.socialnetwork.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {

  private final MessageService messageService;

  @Autowired
  public MessageController(MessageService messageService) {
    this.messageService = messageService;
  }

  @PostMapping("send")
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
