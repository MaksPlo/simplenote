package com.spring.simplenote.controller;

import com.spring.simplenote.dto.NoteGetDto;
import com.spring.simplenote.dto.NotePostDto;
import com.spring.simplenote.model.Note;
import com.spring.simplenote.service.NoteService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
@Api(value = "Operations with notes")
public class NoteController {

    private static final Type LIST_OF_NOTES_TYPE = new TypeToken<List<NoteGetDto>>() {
    }.getType();
    private final NoteService noteService;
    private final ModelMapper modelMapper;


    @ApiOperation("Get all notes")
    @GetMapping
    public List<NoteGetDto> getAllNotes() {
        return modelMapper.map(noteService.getAll(), LIST_OF_NOTES_TYPE);
    }


    @ApiOperation("Create new note")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NoteGetDto create(@RequestBody NotePostDto note) {
        return modelMapper.map(noteService.createNewNote(modelMapper.map(note, Note.class)), NoteGetDto.class);
    }


    @ApiOperation("Delete by title")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        noteService.deleteNote(id);
    }


    @ApiOperation("Find by title")
    @GetMapping("/{title}")
    public List<NoteGetDto> findByTitle(@PathVariable @Nullable String title) {
        return modelMapper.map(noteService.findAllByTitle(title), LIST_OF_NOTES_TYPE);
    }

    @ApiOperation("Find by title")
    @PutMapping("/{id}")
    public NoteGetDto updateNote(@PathVariable String id, String text) {
        return modelMapper.map(noteService.updateNote(id, text), NoteGetDto.class);
    }
}
