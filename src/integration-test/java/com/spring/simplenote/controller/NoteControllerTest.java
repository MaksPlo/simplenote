package com.spring.simplenote.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.simplenote.dto.NotePostDto;
import com.spring.simplenote.model.Note;
import com.spring.simplenote.repository.NoteRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NoteControllerTest {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Before
    public void setUp() {
        Note first = Note.builder()
                .text("First note")
                .title("first title")
                .id("1")
                .build();
        noteRepository.save(first);
        Note second = Note.builder()
                .text("Second note")
                .title("second title")
                .id("2")
                .build();
        noteRepository.save(second);
        Note third = Note.builder()
                .text("third test")
                .title("third test")
                .id("3")
                .build();
        noteRepository.save(third);
        Note fourth = Note.builder()
                .text("fourth test")
                .title("fourth test")
                .id("4")
                .build();
        noteRepository.save(fourth);
    }

    @Test
    public void getAllNotes() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/notes"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].title").value("first title"))
                .andExpect(jsonPath("$[0].text").value("First note"))
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].title").value("second title"))
                .andExpect(jsonPath("$[1].text").value("Second note"))
                .andExpect(jsonPath("$[2].id").value("3"))
                .andExpect(jsonPath("$[2].title").value("third test"))
                .andExpect(jsonPath("$[2].text").value("third test"));
    }

    @Test
    public void create_whenTitleAndTestNotNullAndTitleUnique_CreateNewNote() throws Exception {
        String noteCreateJson = mapper.writeValueAsString(NotePostDto.builder()
                .title("Test from test")
                .text("It is test")
                .build());

        mvc.perform(MockMvcRequestBuilders.post("/notes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(noteCreateJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Test from test"))
                .andExpect(jsonPath("$.text").value("It is test"));
    }

    @Test
    public void create_whenTitleIsNull_getException() throws Exception {
        String noteCreateJson = mapper.writeValueAsString(NotePostDto.builder()
                .text("It is test")
                .build());

        mvc.perform(MockMvcRequestBuilders.post("/notes")
                .content(noteCreateJson))
                .andExpect(status().isUnsupportedMediaType());
    }

    @Test
    public void create_whenTextIsNull_getException() throws Exception {
        String noteCreateJson = mapper.writeValueAsString(NotePostDto.builder()
                .title("Unique")
                .build());

        mvc.perform(MockMvcRequestBuilders.post("/notes")
                .content(noteCreateJson))
                .andExpect(status().isUnsupportedMediaType());
    }

    @Test
    public void create_whenTitleNotUnique_getException() throws Exception {
        String noteCreateJson = mapper.writeValueAsString(NotePostDto.builder()
                .title("first title")
                .text("test")
                .build());

        mvc.perform(MockMvcRequestBuilders.post("/notes")
                .content(noteCreateJson))
                .andExpect(status().isUnsupportedMediaType());
    }

    @Test
    public void delete() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/notes/fourth")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void findByTitle() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/notes/title"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].title").value("first title"))
                .andExpect(jsonPath("$[0].text").value("First note"))
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].title").value("second title"))
                .andExpect(jsonPath("$[1].text").value("Second note"));
    }
}