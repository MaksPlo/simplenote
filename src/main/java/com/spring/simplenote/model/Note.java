package com.spring.simplenote.model;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Document(collection = "notes")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Note {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotNull(message = "title can't be null")
    private String title;

    @NotNull(message = "text can't be null")
    private String text;

}