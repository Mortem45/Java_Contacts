package com.backend.backend.service;

import java.util.List;

import com.backend.backend.entity.Contact;
import com.backend.backend.model.ContactModel;

/**
 * ContactService
 */
public interface ContactService {

  public abstract ContactModel addContact(ContactModel contactModel);

  public abstract List<ContactModel> listAllContacts();

  public abstract Contact findContactById(int id);

  public abstract void removeContact(int id);

  public abstract ContactModel findContactByIdModel(int id);

}