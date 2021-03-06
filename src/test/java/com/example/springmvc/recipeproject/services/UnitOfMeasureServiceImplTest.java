package com.example.springmvc.recipeproject.services;

import com.example.springmvc.recipeproject.commands.UnitOfMeasureCommand;
import com.example.springmvc.recipeproject.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.example.springmvc.recipeproject.domain.UnitOfMeasure;
import com.example.springmvc.recipeproject.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UnitOfMeasureServiceImplTest {

  UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
  UnitOfMeasureService service;

  @Mock
  UnitOfMeasureRepository unitOfMeasureRepository;

  @BeforeEach
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    service = new UnitOfMeasureServiceImpl(unitOfMeasureRepository, unitOfMeasureToUnitOfMeasureCommand);
  }

  @Test
  public void listAllUoms() throws Exception {
    //given
    Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
    UnitOfMeasure uom1 = new UnitOfMeasure();
    uom1.setId(1L);
    unitOfMeasures.add(uom1);

    UnitOfMeasure uom2 = new UnitOfMeasure();
    uom2.setId(2L);
    unitOfMeasures.add(uom2);

    when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasures);

    //when
    Set<UnitOfMeasureCommand> commands = service.listAllUoms();

    //then
    Assertions.assertEquals(2, commands.size());
    verify(unitOfMeasureRepository, times(1)).findAll();
  }
}