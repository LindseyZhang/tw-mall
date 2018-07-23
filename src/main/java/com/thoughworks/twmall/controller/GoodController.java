package com.thoughworks.twmall.controller;

import com.thoughworks.twmall.model.Good;
import com.thoughworks.twmall.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodController {
  private GoodRepository goodRepository;

  @Autowired
  public GoodController(GoodRepository goodRepository) {
    this.goodRepository = goodRepository;
  }

  @GetMapping("/goods")
  public @ResponseBody Iterable<Good> allGoods() {
    return goodRepository.findAll();
  }
}
