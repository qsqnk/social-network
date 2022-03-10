package com.socialnetwork.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MessageEntity {

  @Id
  @GeneratedValue
  private Long id;

  private Long senderId;

  private Long receiverId;

  private String text;

  public Long getSenderId() {
    return senderId;
  }

  public void setSenderId(Long fromId) {
    this.senderId = fromId;
  }

  public Long getReceiverId() {
    return receiverId;
  }

  public void setReceiverId(Long toId) {
    this.receiverId = toId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
