package com.backend.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import com.backend.backend.Component.Converter.ContactConverter;
import com.backend.backend.entity.Contact;
import com.backend.backend.model.ContactModel;
import com.backend.backend.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/**
 * RestController
 */
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

  @Autowired
  @Qualifier("contactRepository")
  private ContactRepository contactRepository;

  @Autowired
  @Qualifier("contactConverter")
  private ContactConverter contactConverter;

  @GetMapping(value="/listcontacts")
  public ResponseEntity<List<ContactModel>> listContacts() {
    List<Contact> contacts = contactRepository.findAll();
    List<ContactModel> contactsModel = new ArrayList<ContactModel>();
    for (Contact contact : contacts) {
     contactsModel.add(contactConverter.convertContactToContactModel(contact));
    }
    return new ResponseEntity<List<ContactModel>>(contactsModel, HttpStatus.OK);
  }


}