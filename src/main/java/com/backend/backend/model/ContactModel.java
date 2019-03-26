package com.backend.backend.model;

/**
 * ContactModel
 */
public class ContactModel {

  private int id;
  private String firstname;
  private String lastname;
  private String telephone;
  private String city;


  public ContactModel() {
  }

  public ContactModel(int id, String firstname, String lastname, String telephone, String city) {
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