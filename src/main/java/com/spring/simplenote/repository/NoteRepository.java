package com.spring.simplenote.repository;

import com.spring.simplenote.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note, String> {
    void deleteByTitle(String title);
    List<Note> findByTitleContaining(String title);

}

