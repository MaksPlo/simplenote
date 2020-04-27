package com.spring.simplenote.repository;

import com.spring.simplenote.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    void deleteByTitle(String title);

    List<Note> findAllByUserId(String userId);
}

