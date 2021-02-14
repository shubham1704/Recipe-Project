package com.example.springmvc.recipeproject.controller;

import com.example.springmvc.recipeproject.services.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
public class IndexController {

  private final RecipeService recipeService;

  @RequestMapping ({"/", "/index", ""})
  public String getIndexPage(Model model) {

    model.addAttribute("recipes", recipeService.getRecipe());

    return "index";
  }
}
