package com.socialnetwork.service;

import com.socialnetwork.entity.UserEntity;
import com.socialnetwork.exceptions.UserAlreadyRegisteredException;
import com.socialnetwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserEntity register(UserEntity user) throws UserAlreadyRegisteredException {
    var username = user.getUsername();
    if (userRepository.existsByUsername(username)) {
      throw new UserAlreadyRegisteredException(username);
    }
    return userRepository.save(user);
  }
}
