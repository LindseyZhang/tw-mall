package com.thoughworks.twmall.login;

import com.thoughworks.twmall.login.model.User;
import com.thoughworks.twmall.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailService implements UserDetailsService {

  private UserRepository userRepository;

  @Autowired
  public JwtUserDetailService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException(String.format("%s dosen't exist!", username));
    } else {
      return new com.thoughworks.twmall.login.security.JwtUser(user);
    }
  }
}
