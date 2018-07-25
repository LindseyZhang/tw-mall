package com.thoughworks.twmall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tw_cart_item")
@Getter
@Setter
public class CartItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "cart_id")
  private Long cartId;

  @Column(name = "good_name")
  private String goodName;
  @Column(name = "good_type")
  private String goodType;
  private double price;
  private int num;
}
