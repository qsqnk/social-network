package com.socialnetwork.repository;

import com.socialnetwork.entity.MessageEntity;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<MessageEntity, Long> {

}
