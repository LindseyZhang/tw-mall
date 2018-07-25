package com.thoughworks.twmall.controller;

import com.thoughworks.twmall.model.Cart;
import com.thoughworks.twmall.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
  private CartRepository cartRepository;

  @Autowired
  public CartController(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  @GetMapping("/carts")
  public @ResponseBody Iterable<Cart> all() {
    return cartRepository.findAll();
  }
}
