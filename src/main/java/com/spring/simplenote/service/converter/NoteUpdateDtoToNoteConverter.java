package com.spring.simplenote.service.converter;

import com.spring.simplenote.dto.NoteUpdateDto;
import com.spring.simplenote.model.Note;
import lombok.RequiredArgsConstructor;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NoteUpdateDtoToNoteConverter extends AbstractConverter<NoteUpdateDto, Note> {

    @Override
    protected Note convert(NoteUpdateDto noteUpdateDto) {
        return Note.builder()
                .id(noteUpdateDto.getId())
                .title(noteUpdateDto.getTitle())
                .text(noteUpdateDto.getText())
                .build();
    }
}
