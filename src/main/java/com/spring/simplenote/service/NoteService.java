package com.spring.simplenote.service;

import com.spring.simplenote.exception.NotFoundException;
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

    public List<Note> getByUserId(String userId) {
        return noteRepository.findAllByUserId(userId);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public Note updateNote(Long noteId, String text) {
        Note note = noteRepository.findById(noteId).orElseThrow(NotFoundException::new);
        note.setText(text);
        noteRepository.save(note);
        return note;
    }
}