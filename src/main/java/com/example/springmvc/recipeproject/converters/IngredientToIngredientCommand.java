package com.example.springmvc.recipeproject.converters;

import com.example.springmvc.recipeproject.commands.IngredientCommand;
import com.example.springmvc.recipeproject.domain.Ingredients;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class IngredientToIngredientCommand implements Converter<Ingredients, IngredientCommand> {

  private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

  public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
    this.uomConverter = uomConverter;
  }

  @Synchronized
  @Nullable
  @Override
  public IngredientCommand convert(Ingredients ingredient) {
    if (ingredient == null) {
      return null;
    }

    IngredientCommand ingredientCommand = new IngredientCommand();
    ingredientCommand.setId(ingredient.getId());
    ingredientCommand.setAmount(ingredient.getAmount());
    ingredientCommand.setDescription(ingredient.getDescription());
    ingredientCommand.setUnitOfMeasure(uomConverter.convert(ingredient.getUom()));
    return ingredientCommand;
  }
}
