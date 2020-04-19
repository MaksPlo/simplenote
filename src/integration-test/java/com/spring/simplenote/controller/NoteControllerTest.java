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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
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
                .time(new Date(System.currentTimeMillis()))
                .build();
        noteRepository.save(first);
        Note second = Note.builder()
                .text("Second note")
                .title("second title")
                .id("2")
                .time(new Date(System.currentTimeMillis()))
                .build();
        noteRepository.save(second);
        Note third = Note.builder()
                .text("third test")
                .title("third test")
                .id("3")
                .time(new Date(System.currentTimeMillis()))
                .build();
        noteRepository.save(third);
        Note fourth = Note.builder()
                .text("fourth test")
                .title("fourth test")
                .id("4")
                .time(new Date(System.currentTimeMillis()))
                .build();
        noteRepository.save(fourth);
    }

    @Test
    @WithMockUser
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
    @WithMockUser
    public void create_whenTitleIsNull_getException() throws Exception {
        String noteCreateJson = mapper.writeValueAsString(NotePostDto.builder()
                .text("It is test")
                .build());

        mvc.perform(MockMvcRequestBuilders.post("/notes")
                .content(noteCreateJson))
                .andExpect(status().isUnsupportedMediaType());
    }

    @Test
    @WithMockUser
    public void create_whenTextIsNull_getException() throws Exception {
        String noteCreateJson = mapper.writeValueAsString(NotePostDto.builder()
                .title("Unique")
                .build());

        mvc.perform(MockMvcRequestBuilders.post("/notes")
                .content(noteCreateJson))
                .andExpect(status().isUnsupportedMediaType());
    }

    @Test
    @WithMockUser
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
    @WithMockUser
    public void delete() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/notes/fourth")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}