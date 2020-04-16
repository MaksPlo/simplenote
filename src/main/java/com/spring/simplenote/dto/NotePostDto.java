package com.spring.simplenote.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class NotePostDto {

    @NotNull
    @JsonProperty("title")
    private String title;

    @NotNull
    @JsonProperty("text")
    private String text;
}
