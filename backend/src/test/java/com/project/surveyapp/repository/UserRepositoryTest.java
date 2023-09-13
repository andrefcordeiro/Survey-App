package com.project.surveyapp.repository;

import com.project.surveyapp.entities.Coordinator;
import com.project.surveyapp.entities.User;
import com.project.surveyapp.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldCreateUser() {
        // Arrange
        User u = new Coordinator(null, "André", "andrefc36@gmail.com", "andrefcordeiro",
                "$2a$10$YF9rmKg5TRUnZ9JObb3czO6Y1aSpC7A6N0RaN/74Hi46R7PhAo7TG");

        // Act
        User savedUser = userRepository.save(u);

        // Assert
        Assertions.assertNotNull(savedUser);
        Assertions.assertTrue(savedUser.getId() > 0);
    }
}
