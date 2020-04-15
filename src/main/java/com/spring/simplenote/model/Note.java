package com.spring.simplenote.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document(collection = "notes")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Note {

    @Id
    private String id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;

}