package com.spring.simplenote.service.converter;

import com.spring.simplenote.dto.NotePostDto;
import com.spring.simplenote.model.Note;
import com.spring.simplenote.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.AbstractConverter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class NotePostDtoToNoteConverter extends AbstractConverter<NotePostDto, Note> {

    @Lazy
    private final UserService userService;

    @Override
    protected Note convert(NotePostDto notePostDto) {
        return Note.builder()
                .text(notePostDto.getText())
                .title(notePostDto.getTitle())
                .time(new Date(System.currentTimeMillis()))
                .user(userService.getCurrentUser())
                .build();
    }
}
