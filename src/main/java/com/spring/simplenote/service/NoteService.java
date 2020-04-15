package com.spring.simplenote.service;

import com.spring.simplenote.model.Note;
import com.spring.simplenote.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public Note createNewNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    public List<Note> findAllByTitle(String title) {
        return noteRepository.findByTitleContaining(title);
    }

    public void deleteNote(String title) {
        noteRepository.deleteByTitle(title);
    }

}