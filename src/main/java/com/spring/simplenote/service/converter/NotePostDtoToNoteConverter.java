package com.spring.simplenote.service.converter;

import com.spring.simplenote.dto.NotePostDto;
import com.spring.simplenote.model.Note;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class NotePostDtoToNoteConverter extends AbstractConverter<NotePostDto, Note> {
    @Override
    protected Note convert(NotePostDto notePostDto) {
        return Note.builder()
                .text(notePostDto.getText())
                .title(notePostDto.getTitle())
                .build();
    }
}
