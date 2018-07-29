package com.thoughworks.twmall.login.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class JwtUtil {

  @Value("${jwt.secret}")
  private String secret;

  public JwtUser parseToken(String token) {
    try {
      Claims body = Jwts.parser()
        .setSigningKey(secret)
        .parseClaimsJws(token)
        .getBody();

      JwtUser u = new JwtUser();
      u.setUsername(body.getSubject());
      u.setId(Long.parseLong((String) body.get("userId")));
      u.setAuthorities(Arrays.asList(new SimpleGrantedAuthority((String) body.get("role"))));
      u.setFullname((String) body.get("fullname"));

      return u;

    } catch (JwtException | ClassCastException e) {
      return null;
    }
  }

  public String generateToken(JwtUser u) {
    Claims claims = Jwts.claims().setSubject(u.getUsername());
    claims.put("userId", u.getId() + "");
    claims.put("role", u.getAuthorities().toString());
    claims.put("fullname", u.getFullname());

    return Jwts.builder()
      .setClaims(claims)
      .signWith(SignatureAlgorithm.HS512, secret)
      .compact();
  }
}
