package com.thoughworks.twmall.login.controller;

import com.thoughworks.twmall.login.JwtUserDetailService;
import com.thoughworks.twmall.login.controller.parameter.LoginRequest;
import com.thoughworks.twmall.login.security.JwtUser;
import com.thoughworks.twmall.login.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.util.Objects;

import static javax.ws.rs.core.Response.ok;

@RestController
public class LoginController {

  private final JwtUtil jwtUtil;
  private final JwtUserDetailService userDetailService;
  private final AuthenticationManager authenticationManager;

  @Autowired
  public LoginController(JwtUtil jwtUtil,
                         JwtUserDetailService userDetailService,
                         AuthenticationManager authenticationManager) {
    this.jwtUtil = jwtUtil;
    this.userDetailService = userDetailService;
    this.authenticationManager = authenticationManager;
  }

  @PostMapping("/login")
  public Response login(@RequestBody LoginRequest loginRequest) {
    authenticate(loginRequest.getUsername(), loginRequest.getPassword());

    final JwtUser user = (JwtUser) userDetailService.loadUserByUsername(loginRequest.getUsername());
    final String token = jwtUtil.generateToken(user);
    return ok(token).build();
  }

  private void authenticate(String username, String password) {
    Objects.requireNonNull(username);
    Objects.requireNonNull(password);

    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    } catch (DisabledException e) {
      throw new AuthenticationException("User is disabled!", e);
    } catch (BadCredentialsException e) {
      throw new AuthenticationException("Bad credentials!", e);
    }
  }

  @ExceptionHandler({AuthenticationException.class})
  public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
  }

}
