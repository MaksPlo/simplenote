package com.spring.simplenote.service;

import com.spring.simplenote.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {
    private final NoteService noteService;

    @Value("${spring.profiles.active}")
    private String profile;


    public Map<String,Object> getUserNotes(User user){
        Map<String, Object> data = new HashMap<>();

        if (user != null) {
            data.put("profile", user);
            data.put("notes", noteService.getAll());
        }
        return data;
    }

    public boolean isDevMode(){
        return "dev".equals(profile);
    }

}
