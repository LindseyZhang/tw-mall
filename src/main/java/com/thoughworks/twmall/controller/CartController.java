package com.thoughworks.twmall.controller;

import com.thoughworks.twmall.model.Cart;
import com.thoughworks.twmall.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
  private CartRepository cartRepository;

  @Autowired
  public CartController(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  @GetMapping("/carts")
  public List<Cart> all(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
    return cartRepository.findAll(new PageRequest(pageNum - 1, pageSize)).getContent();
  }

  @GetMapping("/carts/query")
  public List<Cart> all(@RequestParam(value = "price", defaultValue = "10") double price,
                        @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
    return cartRepository.queryCartByTotalPriceAbove(price, new PageRequest(pageNum - 1, pageSize));
  }
}
