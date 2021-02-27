package com.example.springmvc.recipeproject.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {

  Category category;

  @BeforeEach
  public void setUp() {

    category = new Category();
  }

  @Test
  public void getId() {
    Long idvalue = 4L;
    category.setId(idvalue);
    assertEquals(idvalue, category.getId());
  }
}