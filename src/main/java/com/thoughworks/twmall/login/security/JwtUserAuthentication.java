package com.thoughworks.twmall.login.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtUserAuthentication implements Authentication {
  private JwtUser jwtUser;

  public JwtUserAuthentication(JwtUser jwtUser) {
    this.jwtUser = jwtUser;
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return jwtUser.getAuthorities();
  }

  @Override
  public Object getCredentials() {
    return jwtUser.getPassword();
  }

  @Override
  public Object getDetails() {
    return jwtUser;
  }

  @Override
  public Object getPrincipal() {
    return jwtUser.getUsername();
  }

  @Override
  public boolean isAuthenticated() {
    return true;
  }

  @Override
  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

  }

  @Override
  public String getName() {
    return jwtUser.getFullname();
  }
}
