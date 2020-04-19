package com.spring.simplenote.controller;

import com.spring.simplenote.dto.NoteGetDto;
import com.spring.simplenote.dto.NotePostDto;
import com.spring.simplenote.model.Note;
import com.spring.simplenote.service.NoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
@Api(value = "Operations with notes")
public class NoteController {

    private final NoteService noteService;
    private final ModelMapper modelMapper;

    @ApiOperation("Create new note")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NoteGetDto create(@RequestBody NotePostDto note) {
        return modelMapper.map(noteService.createNewNote(modelMapper.map(note, Note.class)), NoteGetDto.class);
    }


    @ApiOperation("Delete by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        noteService.deleteNote(id);
    }


    @ApiOperation("Update note by id")
    @PutMapping("/{id}")
    public NoteGetDto updateNote(@PathVariable String id, String text) {
        return modelMapper.map(noteService.updateNote(id, text), NoteGetDto.class);
    }
}
