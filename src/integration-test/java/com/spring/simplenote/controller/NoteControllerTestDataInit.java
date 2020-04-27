package com.spring.simplenote.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.simplenote.TestDataInit;
import com.spring.simplenote.dto.NotePostDto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class NoteControllerTestDataInit extends TestDataInit {


    @Autowired
    MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Before
    public void setUp() {
        setupData();
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
        mvc.perform(MockMvcRequestBuilders.delete("/notes/4")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}