package com.example.springmvc.recipeproject.controller;

import com.example.springmvc.recipeproject.domain.Recipe;
import com.example.springmvc.recipeproject.services.RecipeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.anySet;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class IndexControllerTest {

  @Mock
  RecipeService recipeService;

  @Mock
  Model model;

  IndexController controller;

  @BeforeEach
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    controller = new IndexController(recipeService);
  }

  //Fix This

//  @Test
//  public void testMockMVC() throws Exception {
//    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//
//    mockMvc.perform(servletContext -> {return "/";})
//        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.view().name("index"));
//  }

  @Test
  public void getIndexPage() throws Exception {

    //given
    Set<Recipe> recipes = new HashSet<>();
    recipes.add(new Recipe());

    Recipe recipe = new Recipe();
    recipe.setId(1L);

    recipes.add(recipe);

    when(recipeService.getRecipe()).thenReturn(recipes);

    ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

    //when
    String viewName = controller.getIndexPage(model);


    //then
    Assertions.assertEquals("index", viewName);
    verify(recipeService, times(1)).getRecipe();
    verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
    Set<Recipe> setInController = argumentCaptor.getValue();
    Assertions.assertEquals(2, setInController.size());
  }
}