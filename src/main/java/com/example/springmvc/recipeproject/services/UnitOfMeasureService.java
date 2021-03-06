package com.example.springmvc.recipeproject.services;

import com.example.springmvc.recipeproject.commands.UnitOfMeasureCommand;

import java.util.Set;

/**
 * Created by jt on 6/28/17.
 */
public interface UnitOfMeasureService {

  Set<UnitOfMeasureCommand> listAllUoms();
}
