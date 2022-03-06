package com.socialnetwork.repository;

import com.socialnetwork.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

  boolean existsByUsername(String username);

}
