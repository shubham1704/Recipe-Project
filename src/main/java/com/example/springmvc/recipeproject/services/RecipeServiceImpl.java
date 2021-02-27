package com.example.springmvc.recipeproject.services;

import com.example.springmvc.recipeproject.domain.Recipe;
import com.example.springmvc.recipeproject.repositories.RecipeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Service
public class RecipeServiceImpl implements RecipeService {

  RecipeRepository recipeRepository;

  @Override
  public Set<Recipe> getRecipe() {
    Set<Recipe> recipes = new HashSet<>();
    recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
    return recipes;
  }

  @Override
  public Recipe findById(Long id){
    Optional<Recipe> recipeOptional = recipeRepository.findById(id);

    if (!recipeOptional.isPresent()){
      throw new RuntimeException("Recipe Not Found");
    }

    return recipeOptional.get();
  }
}
