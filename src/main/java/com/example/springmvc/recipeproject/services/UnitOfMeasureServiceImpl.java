package com.example.springmvc.recipeproject.services;

import com.example.springmvc.recipeproject.commands.UnitOfMeasureCommand;
import com.example.springmvc.recipeproject.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.example.springmvc.recipeproject.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by jt on 6/28/17.
 */
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

  private final UnitOfMeasureRepository unitOfMeasureRepository;
  private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

  public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
    this.unitOfMeasureRepository = unitOfMeasureRepository;
    this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
  }

  @Override
  public Set<UnitOfMeasureCommand> listAllUoms() {

    return StreamSupport.stream(unitOfMeasureRepository.findAll()
                                    .spliterator(), false)
        .map(unitOfMeasureToUnitOfMeasureCommand::convert)
        .collect(Collectors.toSet());
  }
}
