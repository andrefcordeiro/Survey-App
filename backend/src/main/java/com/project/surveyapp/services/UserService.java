package com.project.surveyapp.services;

import com.project.surveyapp.entities.Coordinator;
import com.project.surveyapp.entities.Respondent;
import com.project.surveyapp.entities.User;
import com.project.surveyapp.entities.enums.UserRole;
import com.project.surveyapp.repositories.CoordinatorRepository;
import com.project.surveyapp.repositories.RespondentRepository;
import com.project.surveyapp.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CoordinatorRepository coordinatorRepository;

    @Autowired
    private RespondentRepository respondentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) {

        if (user.getRole().equals(UserRole.COORDINATOR)){
            Coordinator c = new Coordinator();
            BeanUtils.copyProperties(user, c);
            return coordinatorRepository.save(c);

        } else {
            Respondent r = new Respondent();
            BeanUtils.copyProperties(user, r);
            return respondentRepository.save(r);
        }
    }
}
