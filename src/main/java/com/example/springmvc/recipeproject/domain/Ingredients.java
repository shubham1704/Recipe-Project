package com.example.springmvc.recipeproject.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Data
@Entity
public class Ingredients {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String description;
  private BigDecimal amount;

  @OneToOne(fetch = FetchType.EAGER)
  private UnitOfMeasure uom;

  @ManyToOne
  private Recipe recipe;
}
