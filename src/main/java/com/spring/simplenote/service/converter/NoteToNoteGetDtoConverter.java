package com.spring.simplenote.service.converter;

import com.spring.simplenote.dto.NoteGetDto;
import com.spring.simplenote.model.Note;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class NoteToNoteGetDtoConverter extends AbstractConverter<Note, NoteGetDto> {

    @Override
    protected NoteGetDto convert(Note note) {
        return NoteGetDto.builder()
                .id(note.getId())
                .title(note.getTitle())
                .text(note.getText())
                .time(note.getTime())
                .build();
    }
}
