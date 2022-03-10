package com.socialnetwork.service;

import com.socialnetwork.entity.MessageEntity;
import com.socialnetwork.exceptions.NoSuchUserException;
import com.socialnetwork.repository.MessageRepository;
import com.socialnetwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

  private final UserRepository userRepository;
  private final MessageRepository messageRepository;

  @Autowired
  public MessageService(UserRepository userRepository, MessageRepository messageRepository) {
    this.userRepository = userRepository;
    this.messageRepository = messageRepository;
  }

  public MessageEntity process(MessageEntity message) throws NoSuchUserException {
    var senderId = message.getSenderId();
    var receiverId = message.getReceiverId();
    if (!userRepository.existsById(senderId)) {
      throw new NoSuchUserException(senderId);
    }
    if (!userRepository.existsById(receiverId)) {
      throw new NoSuchUserException(receiverId);
    }
    return messageRepository.save(message);
  }
}
