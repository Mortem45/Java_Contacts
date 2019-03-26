package com.backend.backend.Component.Converter;

import com.backend.backend.entity.Contact;
import com.backend.backend.model.ContactModel;

import org.springframework.stereotype.Component;

/**
 * ContactConverter
 */
@Component("contactConverter")
public class ContactConverter {

  public Contact convertContactModelToContact(ContactModel contactModel) {
    Contact contact = new Contact();
    contact.setId(contactModel.getId());
    contact.setFirstname(contactModel.getFirstname());
    contact.setLastname(contactModel.getLastname());
    contact.setTelephone(contactModel.getTelephone());
    contact.setCity(contactModel.getCity());
    return contact;
  }

  public ContactModel convertContactToContactModel(Contact contact) {
    ContactModel contactModel = new ContactModel();
    contactModel.setId(contact.getId());
    contactModel.setFirstname(contact.getFirstname());
    contactModel.setLastname(contact.getLastname());
    contactModel.setTelephone(contact.getTelephone());
    contactModel.setCity(contact.getCity());
    return contactModel;
  }

}