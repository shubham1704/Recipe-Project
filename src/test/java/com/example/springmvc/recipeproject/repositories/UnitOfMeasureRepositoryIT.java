package com.example.springmvc.recipeproject.repositories;

import com.example.springmvc.recipeproject.domain.UnitOfMeasure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * Created by jt on 6/17/17.
 */
@SpringBootTest
public class UnitOfMeasureRepositoryIT {

  @Autowired
  UnitOfMeasureRepository unitOfMeasureRepository;

  @BeforeEach
  public void setUp() throws Exception {
  }

  @Test
  public void findByDescription() throws Exception {

    Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

    Assertions.assertEquals("Teaspoon", uomOptional.get().getDescription());
  }

  @Test
  public void findByDescriptionCup() throws Exception {

    Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");

    Assertions.assertEquals("Cup", uomOptional.get().getDescription());
  }
}