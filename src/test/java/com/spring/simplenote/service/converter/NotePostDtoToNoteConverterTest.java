package com.spring.simplenote.service.converter;

import com.spring.simplenote.dto.NotePostDto;
import com.spring.simplenote.model.Note;
import com.spring.simplenote.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class NotePostDtoToNoteConverterTest {

    private ModelMapper modelMapper;

    private NotePostDtoToNoteConverter notePostDtoToNoteConverter;

    @Mock
    private UserService userService;

    @Before
    public void setUp() {
        modelMapper = new ModelMapper();
        notePostDtoToNoteConverter = new NotePostDtoToNoteConverter(userService);
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