package com.backend.backend.controller;

import com.backend.backend.Constant.ViewConstant;
import com.backend.backend.model.ContactModel;
import com.backend.backend.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;




/**
 * ContactController
 */
@Controller
@RequestMapping("/contacts")
public class ContactController {

  @Autowired
  @Qualifier("contactServiceImpl")
  private ContactService contactService;

  @GetMapping("/cancel")
  public String cancel() {
    return "redirect:/contacts/showcontacts";
  }

  @PreAuthorize("hasRole('ROLE_USER')")
  @GetMapping("/contactform")
  public String redirectContactForm(@RequestParam(name="id", required = false) int id, Model model) {
    ContactModel contact = new ContactModel();
    if (id != 0) {
      contact = contactService.findContactByIdModel(id);
    }
    model.addAttribute("contactModel", contact);
      return ViewConstant.CONTANT_FORM;
  }

  @PostMapping("/addcontact")
  public String addcontact(@ModelAttribute ContactModel contactModel, Model model) {

    System.out.println(contactModel.toString());
    if (null != contactService.addContact(contactModel)) {
      model.addAttribute("result", 1);
    } else {
      model.addAttribute("result", 0);
    }
    return "redirect:/contacts/showcontacts";
  }

  @GetMapping("/showcontacts")
  public ModelAndView showContacts() {
    ModelAndView mav = new ModelAndView(ViewConstant.CONTANTS);
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    mav.addObject("username", user.getUsername());
    mav.addObject("contacts", contactService.listAllContacts());
    return mav;
    }

  @GetMapping(value="/removecontact")
  public ModelAndView removeContact(@RequestParam(name="id", required = true) int id) {
      contactService.removeContact(id);
      return showContacts();
  }

}