package com.example.springmvc.recipeproject.services;

import com.example.springmvc.recipeproject.commands.IngredientCommand;

/**
 * Created by jt on 6/27/17.
 */
public interface IngredientService {

  IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
