package com.spring.simplenote.service;

import com.spring.simplenote.exception.NotFoundException;
import com.spring.simplenote.model.User;
import com.spring.simplenote.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final NoteService noteService;
    private final UserRepository userRepository;


    public List<User> getUserNotes(User user) {
        List<User> data = new ArrayList<>();

        if (user != null) {
            user.setNotes(noteService.getByUserId(user.getId()));
            data.add(user);
        }
        return data;
    }


    public User getCurrentUser() {
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByEmail(userDetails.getEmail()).orElseThrow(NotFoundException::new);
    }

}
