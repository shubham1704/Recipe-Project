package com.example.springmvc.recipeproject.services;

import com.example.springmvc.recipeproject.commands.RecipeCommand;
import com.example.springmvc.recipeproject.converters.RecipeCommandToRecipe;
import com.example.springmvc.recipeproject.converters.RecipeToRecipeCommand;
import com.example.springmvc.recipeproject.domain.Recipe;
import com.example.springmvc.recipeproject.repositories.RecipeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Service
public class RecipeServiceImpl implements RecipeService {

  private final RecipeRepository recipeRepository;
  private final RecipeCommandToRecipe recipeCommandToRecipe;
  private final RecipeToRecipeCommand recipeToRecipeCommand;

  @Override
  public Set<Recipe> getRecipes() {
    log.debug("I'm in the service");

    Set<Recipe> recipeSet = new HashSet<>();
    recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
    return recipeSet;
  }

  @Override
  public Recipe findById(Long l) {

    Optional<Recipe> recipeOptional = recipeRepository.findById(l);

    if (!recipeOptional.isPresent()) {
      throw new RuntimeException("Recipe Not Found!");
    }

    return recipeOptional.get();
  }

  @Override
  @Transactional
  public RecipeCommand saveRecipeCommand(RecipeCommand command) {
    Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

    Recipe savedRecipe = recipeRepository.save(detachedRecipe);
    log.debug("Saved RecipeId:" + savedRecipe.getId());
    return recipeToRecipeCommand.convert(savedRecipe);
  }

  @Override
  @Transactional
  public RecipeCommand findCommandById(Long l) {
    return recipeToRecipeCommand.convert(findById(l));
  }

  @Override
  public void deleteById(Long idToDelete) {
    recipeRepository.deleteById(idToDelete);
  }
}