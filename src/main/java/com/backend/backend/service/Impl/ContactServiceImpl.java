package com.backend.backend.service.Impl;

import java.util.ArrayList;
import java.util.List;


import com.backend.backend.Component.Converter.ContactConverter;
import com.backend.backend.entity.Contact;
import com.backend.backend.model.ContactModel;
import com.backend.backend.repository.ContactRepository;
import com.backend.backend.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * ContactServiceImpl
 */
@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {
  @Autowired
  @Qualifier("contactRepository")
  private ContactRepository contactRepository;

  @Autowired
  @Qualifier("contactConverter")
  private ContactConverter contactConverter;

  @Override
  public ContactModel addContact(ContactModel contactModel) {
    Contact contact = contactRepository.save(contactConverter.convertContactModelToContact(contactModel));
    return contactConverter.convertContactToContactModel(contact);
  }

  @Override
  public List<ContactModel> listAllContacts() {
     List<Contact>contacts = contactRepository.findAll();
     List<ContactModel> contactsModel = new ArrayList<ContactModel>();
     for (Contact contact : contacts) {
      contactsModel.add(contactConverter.convertContactToContactModel(contact));
     }
    return contactsModel;
  }

  @Override
  public Contact findContactById(int id) {
    return contactRepository.findById(id);
  }

  @Override
  public ContactModel findContactByIdModel(int id) {
    return contactConverter.convertContactToContactModel(findContactById(id));
  }

  @Override
  public void removeContact(int id) {
    Contact contact = findContactById(id);
    if (contact != null) {
      contactRepository.delete(contact);
    }
  }

}