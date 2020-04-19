package com.spring.simplenote.repository;

import com.spring.simplenote.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {
    void deleteByTitle(String title);
}

