package com.example.springmvc.recipeproject.converters;

import com.example.springmvc.recipeproject.commands.NotesCommand;
import com.example.springmvc.recipeproject.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NotesCommandToNotesTest {

  public static final Long ID_VALUE = new Long(1L);
  public static final String RECIPE_NOTES = "Notes";
  NotesCommandToNotes converter;

  @BeforeEach
  public void setUp() throws Exception {
    converter = new NotesCommandToNotes();
  }

  @Test
  public void testNullParameter() throws Exception {
    assertNull(converter.convert(null));
  }

  @Test
  public void testEmptyObject() throws Exception {
    assertNotNull(converter.convert(new NotesCommand()));
  }

  @Test
  public void convert() throws Exception {
    //given
    NotesCommand notesCommand = new NotesCommand();
    notesCommand.setId(ID_VALUE);
    notesCommand.setRecipeNotes(RECIPE_NOTES);

    //when
    Notes notes = converter.convert(notesCommand);

    //then
    assertNotNull(notes);
    assertEquals(ID_VALUE, notes.getId());
    assertEquals(RECIPE_NOTES, notes.getRecipeNotes());
  }
}