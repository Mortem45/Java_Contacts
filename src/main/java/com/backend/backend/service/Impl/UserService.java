package com.backend.backend.service.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.backend.backend.entity.User;
import com.backend.backend.entity.UserRole;
import com.backend.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service("userService")
public class UserService implements UserDetailsService {

  @Autowired
  @Qualifier("userRepository")
  private UserRepository userRepository;


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    List<GrantedAuthority> authorities = buildAutorities(user.getUserRole());
    return builduser(user, authorities);
  }

  private org.springframework.security.core.userdetails.User builduser(User user, List<GrantedAuthority> authorities) {
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getEnable(), true, true, true, authorities);
  }

  private List<GrantedAuthority> buildAutorities (Set<UserRole> userRoles) {
    Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
    for (UserRole userRole : userRoles) {
      auths.add(new SimpleGrantedAuthority(userRole.getRole()));
    }
    return new ArrayList<GrantedAuthority>(auths);
  }

}