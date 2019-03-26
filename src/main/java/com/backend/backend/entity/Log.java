package com.backend.backend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * log
 */
@Entity
@Table(name = "log")
public class Log {

  @Id
  @GeneratedValue
  @Column
  private int id;
  @Column
  private Date date;
  @Column
  private String details;
  @Column
  private String username;
  @Column
  private String url;


  public Log() {
  }

  public Log(Date date, String details, String username, String url) {
    this.date = date;
    this.details = details;
    this.username = username;
    this.url = url;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getDetails() {
    return this.details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", date='" + getDate() + "'" +
      ", details='" + getDetails() + "'" +
      ", username='" + getUsername() + "'" +
      ", url='" + getUrl() + "'" +
      "}";
  }

 }