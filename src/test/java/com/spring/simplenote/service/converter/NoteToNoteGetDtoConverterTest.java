package com.spring.simplenote.service.converter;

import com.spring.simplenote.dto.NoteGetDto;
import com.spring.simplenote.model.Note;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;

public class NoteToNoteGetDtoConverterTest {

    private ModelMapper modelMapper;

    private NoteToNoteGetDtoConverter noteToNoteGetDtoConverter;

    @Before
    public void setUp() {
        modelMapper = new ModelMapper();
        noteToNoteGetDtoConverter = new NoteToNoteGetDtoConverter();
        modelMapper.addConverter(noteToNoteGetDtoConverter);
    }

    @Test
    public void convert() {
        Note note = Note.builder()
                .id("1")
                .title("Test title")
                .text("test text")
                .build();

        NoteGetDto noteGetDto = modelMapper.map(note, NoteGetDto.class);

        assertEquals("test text", noteGetDto.getText());
        assertEquals("Test title", noteGetDto.getTitle());
        assertEquals("1", noteGetDto.getId());
    }
}