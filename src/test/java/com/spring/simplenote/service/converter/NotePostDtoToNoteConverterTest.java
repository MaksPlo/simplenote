package com.spring.simplenote.service.converter;

import com.spring.simplenote.dto.NotePostDto;
import com.spring.simplenote.model.Note;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;

public class NotePostDtoToNoteConverterTest {

    private ModelMapper modelMapper;

    private NotePostDtoToNoteConverter notePostDtoToNoteConverter;

    @Before
    public void setUp() {
        modelMapper = new ModelMapper();
        notePostDtoToNoteConverter = new NotePostDtoToNoteConverter();
        modelMapper.addConverter(notePostDtoToNoteConverter);
    }

    @Test
    public void convert_whenDtoCorrect_convertToNote() {
        NotePostDto notePostDto = NotePostDto.builder()
                .text("test text")
                .title("test title")
                .build();

        Note note = modelMapper.map(notePostDto, Note.class);

        assertEquals("test text", note.getText());
        assertEquals("test title", note.getTitle());
    }
}