package com.project.surveyapp.repositories;

import com.project.surveyapp.entities.Coordinator;
import com.project.surveyapp.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void setup() {
        String encryptedPassword = new BCryptPasswordEncoder().encode("12345");
        this.user = new Coordinator(null, "André", "andrefc36@gmail.com", "andrefcordeiro",
                encryptedPassword);
    }

    @Test
    void shouldCreateUser() {
        User savedUser = userRepository.save(this.user);

        Assertions.assertNotNull(savedUser);
        Assertions.assertTrue(savedUser.getId() > 0);
    }

    @Test
    void shouldFindUserByUsername() {
        userRepository.save(this.user);
        UserDetails savedUser = userRepository.findByUsername("andrefcordeiro");

        Assertions.assertNotNull(savedUser);
    }
}
