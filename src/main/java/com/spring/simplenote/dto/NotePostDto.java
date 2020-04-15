package com.spring.simplenote.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class NotePostDto {

    @JsonProperty("title")
    private String title;

    @JsonProperty("text")
    private String text;
}
