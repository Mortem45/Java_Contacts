package com.backend.backend.Component.Converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * TestCryps
 */
public class TestCryps {

  public static void main(String[] args) {
    BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
    System.out.println(pe.encode("user"));
  }
}