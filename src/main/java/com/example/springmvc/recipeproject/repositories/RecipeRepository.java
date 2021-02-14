package com.example.springmvc.recipeproject.repositories;

import com.example.springmvc.recipeproject.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
