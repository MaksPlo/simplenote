package com.spring.simplenote.service;

import com.spring.simplenote.model.Note;
import com.spring.simplenote.model.User;
import com.spring.simplenote.repository.NoteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;
import static org.junit.Assert.assertEquals;
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
                .id(1L)
                .title("Test title")
                .text("test text")
                .build();
        when(noteRepository.save(note)).thenReturn(note);

        Note returnedNote = noteService.createNewNote(note);

        verify(noteRepository, atLeastOnce()).save(any());
        assertEquals(1, returnedNote.getId().intValue());
        assertEquals("Test title", returnedNote.getTitle());
        assertEquals("test text", returnedNote.getText());
    }

    @Test
    public void getByUserId() {
        User user = User.builder()
                .name("Test User")
                .email("test@mail.ru")
                .gender("")
                .locale("ru")
                .userpic("qwqd")
                .id("dsdcsd")
                .build();

        List<Note> notes = new ArrayList<>();
        Note first = Note.builder()
                .id(1L)
                .title("Test first")
                .text("test first")
                .user(user)
                .build();
        notes.add(first);
        Note second = Note.builder()
                .id(2L)
                .title("Test second")
                .text("test second")
                .user(user)
                .build();
        notes.add(second);
        when(noteRepository.findAllByUserId("dsdcsd")).thenReturn(notes);

        List<Note> returnedNotes = noteService.getByUserId("dsdcsd");

        verify(noteRepository, atLeastOnce()).findAllByUserId(any());
        assertEquals(2, returnedNotes.size());
        assertEquals(1, returnedNotes.get(0).getId().intValue());
        assertEquals("Test first", returnedNotes.get(0).getTitle());
        assertEquals("test first", returnedNotes.get(0).getText());
        assertEquals(2, returnedNotes.get(1).getId().intValue());
        assertEquals("Test second", returnedNotes.get(1).getTitle());
        assertEquals("test second", returnedNotes.get(1).getText());
    }

    @Test
    public void deleteNote() {
        noteService.deleteNote(1L);

        verify(noteRepository, atLeastOnce()).deleteById(any());
    }

    @Test
    public void updateNote(){
        Note notUpdated = Note.builder()
                .id(1L)
                .title("Test first")
                .text("test first")
                .build();

        Note updated = Note.builder()
                .id(1L)
                .title("Test first")
                .text("update")
                .build();
        when(noteRepository.findById(1L)).thenReturn(ofNullable(notUpdated));
        when(noteRepository.save(updated)).thenReturn(updated);

        Note noteAfterUpdate = noteService.updateNote(1L, "update");

        verify(noteRepository, atLeastOnce()).findById(any());
        verify(noteRepository, atLeastOnce()).save(any());
        assertEquals(1, noteAfterUpdate.getId().intValue());
        assertEquals("update", noteAfterUpdate.getText());
        assertEquals("Test first", noteAfterUpdate.getTitle());
    }
}