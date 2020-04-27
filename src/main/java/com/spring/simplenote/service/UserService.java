package com.spring.simplenote.service;

import com.spring.simplenote.exception.NotFoundException;
import com.spring.simplenote.model.User;
import com.spring.simplenote.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {
    private final NoteService noteService;
    private final UserRepository userRepository;


    public Map<String, Object> getUserNotes(User user) {
        Map<String, Object> data = new HashMap<>();

        if (user != null) {
            data.put("profile", user);
            data.put("notes", noteService.getByUserId(user.getId()));
        }
        return data;
    }


    public User getCurrentUser() {
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findById(userDetails.getId()).orElseThrow(NotFoundException::new);
    }

}
