package com.spring.simplenote.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "notes")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Note implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique=true)
    private Long id;

//    @NotNull(message = "title can't be null")
    @Column(unique = true)
    private String title;

//    @NotNull(message = "text can't be null")
    private String text;

//    @NotNull(message = "time can't be null")
    private Date time;

    @ManyToOne
    private User user;


}