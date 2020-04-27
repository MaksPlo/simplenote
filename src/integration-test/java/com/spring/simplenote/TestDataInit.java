package com.spring.simplenote;

import com.spring.simplenote.model.Note;
import com.spring.simplenote.model.User;
import com.spring.simplenote.repository.NoteRepository;
import com.spring.simplenote.repository.UserRepository;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/sql/reset_tables.sql")
})
public class TestDataInit {

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = PostgresqlContainer.getInstance();

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;


    public void setupData(){
        User user = User.builder()
                .userpic("url")
                .locale("US")
                .gender("")
                .email("test@mail.com")
                .name("Test User")
                .id("123")
                .build();
        userRepository.save(user);

        Note first = Note.builder()
                .text("First note")
                .title("first title")
                .id(1L)
                .time(new Date(System.currentTimeMillis()))
                .user(user)
                .build();
        noteRepository.save(first);
        Note second = Note.builder()
                .text("Second note")
                .title("second title")
                .id(2L)
                .time(new Date(System.currentTimeMillis()))
                .user(user)
                .build();
        noteRepository.save(second);
        Note third = Note.builder()
                .text("third test")
                .title("third test")
                .id(3L)
                .time(new Date(System.currentTimeMillis()))
                .user(user)
                .build();
        noteRepository.save(third);
        Note fourth = Note.builder()
                .text("fourth test")
                .title("fourth test")
                .id(4L)
                .time(new Date(System.currentTimeMillis()))
                .user(user)
                .build();
        noteRepository.save(fourth);
    }
}
