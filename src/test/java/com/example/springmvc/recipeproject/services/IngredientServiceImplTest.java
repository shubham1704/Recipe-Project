package com.example.springmvc.recipeproject.services;

import com.example.springmvc.recipeproject.commands.IngredientCommand;
import com.example.springmvc.recipeproject.converters.IngredientToIngredientCommand;
import com.example.springmvc.recipeproject.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.example.springmvc.recipeproject.domain.Ingredients;
import com.example.springmvc.recipeproject.domain.Recipe;
import com.example.springmvc.recipeproject.repositories.RecipeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IngredientServiceImplTest {

  private final IngredientToIngredientCommand ingredientToIngredientCommand;

  @Mock
  RecipeRepository recipeRepository;

  IngredientService ingredientService;

  //init converters
  public IngredientServiceImplTest() {
    this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
  }

  @BeforeEach
  public void setUp() throws Exception {
    MockitoAnnotations.openMocks(this);

    ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, recipeRepository);
  }

  @Test
  public void findByRecipeIdAndId() throws Exception {
  }

  @Test
  public void findByRecipeIdAndReceipeIdHappyPath() throws Exception {
    //given
    Recipe recipe = new Recipe();
    recipe.setId(1L);

    Ingredients ingredient1 = new Ingredients();
    ingredient1.setId(1L);

    Ingredients ingredient2 = new Ingredients();
    ingredient2.setId(1L);

    Ingredients ingredient3 = new Ingredients();
    ingredient3.setId(3L);

    recipe.addIngredient(ingredient1);
    recipe.addIngredient(ingredient2);
    recipe.addIngredient(ingredient3);
    Optional<Recipe> recipeOptional = Optional.of(recipe);

    when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

    //then
    IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 3L);

    //when
    Assertions.assertEquals(Long.valueOf(3L), ingredientCommand.getId());
    Assertions.assertEquals(Long.valueOf(1L), ingredientCommand.getRecipeId());
    verify(recipeRepository, times(1)).findById(anyLong());
  }
}