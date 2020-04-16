package com.spring.simplenote.service;

import com.spring.simplenote.model.Note;
import com.spring.simplenote.repository.NoteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class NoteServiceTest {

    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteService noteService;

    @Test
    public void createNewNote() {
        Note note = Note.builder()
                .id("1")
                .title("Test title")
                .text("test text")
                .build();
        when(noteRepository.save(note)).thenReturn(note);

        Note returnedNote = noteService.createNewNote(note);

        verify(noteRepository, atLeastOnce()).save(any());
        assertEquals("1", returnedNote.getId());
        assertEquals("Test title", returnedNote.getTitle());
        assertEquals("test text", returnedNote.getText());
    }

    @Test
    public void getAll() {
        List<Note> notes = new ArrayList<>();
        Note first = Note.builder()
                .id("1")
                .title("Test first")
                .text("test first")
                .build();
        notes.add(first);
        Note second = Note.builder()
                .id("2")
                .title("Test second")
                .text("test second")
                .build();
        notes.add(second);
        when(noteRepository.findAll()).thenReturn(notes);

        List<Note> returnedNotes = noteService.getAll();

        verify(noteRepository, atLeastOnce()).findAll();
        assertEquals(2, returnedNotes.size());
        assertEquals("1", returnedNotes.get(0).getId());
        assertEquals("Test first", returnedNotes.get(0).getTitle());
        assertEquals("test first", returnedNotes.get(0).getText());
        assertEquals("2", returnedNotes.get(1).getId());
        assertEquals("Test second", returnedNotes.get(1).getTitle());
        assertEquals("test second", returnedNotes.get(1).getText());
    }

    @Test
    public void findAllByTitle() {
        List<Note> notes = new ArrayList<>();
        Note first = Note.builder()
                .id("1")
                .title("Test first")
                .text("test first")
                .build();
        notes.add(first);
        Note second = Note.builder()
                .id("2")
                .title("Test second")
                .text("test second")
                .build();
        notes.add(second);
        when(noteRepository.findByTitleContaining("Test")).thenReturn(notes);

        List<Note> returnedNotes = noteService.findAllByTitle("Test");

        verify(noteRepository, atLeastOnce()).findByTitleContaining(any());
        assertEquals("1", returnedNotes.get(0).getId());
        assertEquals("Test first", returnedNotes.get(0).getTitle());
        assertEquals("test first", returnedNotes.get(0).getText());
        assertEquals("2", returnedNotes.get(1).getId());
        assertEquals("Test second", returnedNotes.get(1).getTitle());
        assertEquals("test second", returnedNotes.get(1).getText());
    }

    @Test
    public void deleteNote() {
        noteService.deleteNote("test");

        verify(noteRepository, atLeastOnce()).deleteByTitle(any());
    }
}