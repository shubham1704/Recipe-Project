package com.example.springmvc.recipeproject.services;

import com.example.springmvc.recipeproject.commands.RecipeCommand;
import com.example.springmvc.recipeproject.domain.Recipe;

import java.util.Set;

public interface RecipeService {

  Set<Recipe> getRecipes();

  Recipe findById(Long l);

  RecipeCommand findCommandById(Long l);

  RecipeCommand saveRecipeCommand(RecipeCommand command);

  void deleteById(Long idToDelete);

}
