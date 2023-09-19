package com.project.surveyapp.services;

import com.project.surveyapp.entities.Coordinator;
import com.project.surveyapp.entities.Respondent;
import com.project.surveyapp.entities.User;
import com.project.surveyapp.entities.enums.UserRole;
import com.project.surveyapp.repositories.CoordinatorRepository;
import com.project.surveyapp.repositories.RespondentRepository;
import com.project.surveyapp.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private CoordinatorRepository coordinatorRepository;

    @Mock
    private RespondentRepository respondentRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    public void setup() {
        String encryptedPassword = new BCryptPasswordEncoder().encode("12345");
        this.user = new User(null, "André", "andrefc36@gmail.com", "andrefcordeiro",
                encryptedPassword, UserRole.COORDINATOR);
    }

    @Test
    void shouldCreateUserCoordinator() {
        Coordinator c = new Coordinator();
        BeanUtils.copyProperties(this.user, c);
        Mockito.when(coordinatorRepository.save(Mockito.any(Coordinator.class))).thenReturn(c);

        User savedUser = userService.createUser(c);

        Assertions.assertNotNull(savedUser);
    }

    @Test
    void shouldCreateUserRespondent() {
        Respondent r = new Respondent();
        BeanUtils.copyProperties(this.user, r);
        r.setRole(UserRole.RESPONDENT);
        Mockito.when(respondentRepository.save(Mockito.any(Respondent.class))).thenReturn(r);

        User savedUser = userService.createUser(r);

        Assertions.assertNotNull(savedUser);
    }

    @Test
    void shouldLoadUserByUsername() {
        Mockito.when(userRepository.findByUsername("andrefcordeiro")).thenReturn(this.user);

        User savedUser = (User) userService.loadUserByUsername("andrefcordeiro");

        Assertions.assertNotNull(savedUser);
    }
}
