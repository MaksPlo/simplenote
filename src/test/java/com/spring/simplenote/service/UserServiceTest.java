package com.spring.simplenote.service;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class UserServiceTest {
//
//    @Mock
//    private NoteService noteService;
//
//    @InjectMocks
//    private UserService userService;
//
//    @Test
//    void getUserNotes() {
//        MockitoAnnotations.initMocks(this);
//        List<Note> notes = new ArrayList<>();
//        Note first = Note.builder()
//                .id("1")
//                .title("Test first")
//                .text("test first")
//                .build();
//        notes.add(first);
//        Note second = Note.builder()
//                .id("2")
//                .title("Test second")
//                .text("test second")
//                .build();
//        notes.add(second);
//
//        when(noteService.getAll()).thenReturn(notes);
//
//        User user = User.builder()
//                .locale("Russia")
//                .gender("man")
//                .userpic("Url")
//                .email("test@mail.com")
//                .name("TestUser")
//                .id("123098")
//                .build();
//
//        Map<String, Object> map = userService.getUserNotes(user);
//        List<Note> resultNotes = ((List<Note>) map.get("notes"));
//        User resultUser = ((User) map.get("profile"));
//
//        verify(noteService, atLeastOnce()).getAll();
//        assertEquals(2, resultNotes.size());
//        assertEquals("1", resultNotes.get(0).getId());
//        assertEquals("Test first", resultNotes.get(0).getTitle());
//        assertEquals("test first", resultNotes.get(0).getText());
//        assertEquals("2", resultNotes.get(1).getId());
//        assertEquals("Test second", resultNotes.get(1).getTitle());
//        assertEquals("test second", resultNotes.get(1).getText());
//        assertEquals("test@mail.com", resultUser.getEmail());
//        assertEquals("man", resultUser.getGender());
//        assertEquals("123098", resultUser.getId());
//        assertEquals("Russia", resultUser.getLocale());
//        assertEquals("TestUser", resultUser.getName());
//        assertEquals("Url", resultUser.getUserpic());
//    }
}