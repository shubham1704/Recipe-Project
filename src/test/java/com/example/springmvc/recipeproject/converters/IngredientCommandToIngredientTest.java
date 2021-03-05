package com.example.springmvc.recipeproject.converters;

import com.example.springmvc.recipeproject.commands.IngredientCommand;
import com.example.springmvc.recipeproject.commands.UnitOfMeasureCommand;
import com.example.springmvc.recipeproject.domain.Ingredients;
import com.example.springmvc.recipeproject.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class IngredientCommandToIngredientTest {

  public static final Recipe RECIPE = new Recipe();
  public static final BigDecimal AMOUNT = new BigDecimal("1");
  public static final String DESCRIPTION = "Cheeseburger";
  public static final Long ID_VALUE = new Long(1L);
  public static final Long UOM_ID = new Long(2L);

  IngredientCommandToIngredient converter;

  @BeforeEach
  public void setUp() throws Exception {
    converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
  }

  @Test
  public void testNullObject() throws Exception {
    assertNull(converter.convert(null));
  }

  @Test
  public void testEmptyObject() throws Exception {
    assertNotNull(converter.convert(new IngredientCommand()));
  }

  @Test
  public void convert() throws Exception {
    //given
    IngredientCommand command = new IngredientCommand();
    command.setId(ID_VALUE);
    command.setAmount(AMOUNT);
    command.setDescription(DESCRIPTION);
    UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
    unitOfMeasureCommand.setId(UOM_ID);
    command.setUnitOfMeasure(unitOfMeasureCommand);

    //when
    Ingredients ingredient = converter.convert(command);

    //then
    assertNotNull(ingredient);
    assertNotNull(ingredient.getUom());
    assertEquals(ID_VALUE, ingredient.getId());
    assertEquals(AMOUNT, ingredient.getAmount());
    assertEquals(DESCRIPTION, ingredient.getDescription());
    assertEquals(UOM_ID, ingredient.getUom().getId());
  }

  @Test
  public void convertWithNullUOM() throws Exception {
    //given
    IngredientCommand command = new IngredientCommand();
    command.setId(ID_VALUE);
    command.setAmount(AMOUNT);
    command.setDescription(DESCRIPTION);
    UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();

    //when
    Ingredients ingredient = converter.convert(command);

    //then
    assertNotNull(ingredient);
    assertNull(ingredient.getUom());
    assertEquals(ID_VALUE, ingredient.getId());
    assertEquals(AMOUNT, ingredient.getAmount());
    assertEquals(DESCRIPTION, ingredient.getDescription());
  }
}