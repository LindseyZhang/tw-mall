package com.thoughworks.twmall.repository;

import com.thoughworks.twmall.model.Cart;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

  @Query(value = "select c from Cart c where totalPrice > :price")
  List<Cart> queryCartByTotalPriceAbove(double price, Pageable pageable);
}
