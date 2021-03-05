package com.example.springmvc.recipeproject.converters;

import com.example.springmvc.recipeproject.commands.IngredientCommand;
import com.example.springmvc.recipeproject.domain.Ingredients;
import com.example.springmvc.recipeproject.domain.Recipe;
import com.example.springmvc.recipeproject.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Created by jt on 6/21/17.
 */
public class IngredientToIngredientCommandTest {

  public static final Recipe RECIPE = new Recipe();
  public static final BigDecimal AMOUNT = new BigDecimal("1");
  public static final String DESCRIPTION = "Cheeseburger";
  public static final Long UOM_ID = new Long(2L);
  public static final Long ID_VALUE = new Long(1L);

  IngredientToIngredientCommand converter;

  @BeforeEach
  public void setUp() throws Exception {
    converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
  }

  @Test
  public void testNullConvert() throws Exception {
    assertNull(converter.convert(null));
  }

  @Test
  public void testEmptyObject() throws Exception {
    assertNotNull(converter.convert(new Ingredients()));
  }

  @Test
  public void testConvertNullUOM() throws Exception {
    //given
    Ingredients ingredient = new Ingredients();
    ingredient.setId(ID_VALUE);
    ingredient.setRecipe(RECIPE);
    ingredient.setAmount(AMOUNT);
    ingredient.setDescription(DESCRIPTION);
    ingredient.setUom(null);
    //when
    IngredientCommand ingredientCommand = converter.convert(ingredient);
    //then
    assertNull(ingredientCommand.getUom());
    assertEquals(ID_VALUE, ingredientCommand.getId());
    // assertEquals(RECIPE, ingredientCommand.get);
    assertEquals(AMOUNT, ingredientCommand.getAmount());
    assertEquals(DESCRIPTION, ingredientCommand.getDescription());
  }

  @Test
  public void testConvertWithUom() throws Exception {
    //given
    Ingredients ingredient = new Ingredients();
    ingredient.setId(ID_VALUE);
    ingredient.setRecipe(RECIPE);
    ingredient.setAmount(AMOUNT);
    ingredient.setDescription(DESCRIPTION);

    UnitOfMeasure uom = new UnitOfMeasure();
    uom.setId(UOM_ID);

    ingredient.setUom(uom);
    //when
    IngredientCommand ingredientCommand = converter.convert(ingredient);
    //then
    assertEquals(ID_VALUE, ingredientCommand.getId());
    assertNotNull(ingredientCommand.getUom());
    assertEquals(UOM_ID, ingredientCommand.getUom().getId());
    // assertEquals(RECIPE, ingredientCommand.get);
    assertEquals(AMOUNT, ingredientCommand.getAmount());
    assertEquals(DESCRIPTION, ingredientCommand.getDescription());
  }
}