package com.thoughworks.twmall.repository;

import com.thoughworks.twmall.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
