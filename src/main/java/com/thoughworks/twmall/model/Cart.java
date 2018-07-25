package com.thoughworks.twmall.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tw_cart")
public class Cart {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "total_price")
  private double totalPrice;

  @JoinColumn(name = "cart_id")
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<CartItem> cartItems = new ArrayList<>();

  public long getId() {
    return id;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public List<CartItem> getCartItems() {
    return cartItems;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public void setCartItems(List<CartItem> cartItems) {
    this.cartItems = cartItems;
  }
}
