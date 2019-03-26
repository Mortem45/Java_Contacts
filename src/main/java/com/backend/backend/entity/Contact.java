package com.backend.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Contact
 */
@Entity
@Table(name="contact")
public class Contact {

  @Id
  @GeneratedValue
  @Column(name="id")
  private int id;
  @Column(name="firstname")
  private String firstname;
  @Column(name="lastname")
  private String lastname;
  @Column(name="telephone")
  private String telephone;
  @Column(name="city")
  private String city;


  public Contact() {
  }

  public Contact(int id, String firstname, String lastname, String telephone, String city) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.telephone = telephone;
    this.city = city;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstname() {
    return this.firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return this.lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getTelephone() {
    return this.telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", firstname='" + getFirstname() + "'" +
      ", lastname='" + getLastname() + "'" +
      ", telephone='" + getTelephone() + "'" +
      ", city='" + getCity() + "'" +
      "}";
  }



}