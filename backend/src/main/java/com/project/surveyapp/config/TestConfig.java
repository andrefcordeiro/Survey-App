package com.project.surveyapp.config;

import com.project.surveyapp.entities.Coordinator;
import com.project.surveyapp.entities.Survey;
import com.project.surveyapp.repositories.CoordinatorRepository;
import com.project.surveyapp.repositories.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CoordinatorRepository coordinatorRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public void run(String... args) throws Exception {
        Coordinator c1 = new Coordinator(null, "André", "andrefc36@gmail.com", "andrefcordeiro", "12345");

        coordinatorRepository.save(c1);

        Survey s1 = new Survey(null, "Survey 1", LocalDate.of(2023, 8, 13), c1);
        Survey s2 = new Survey(null, "Survey 2", LocalDate.of(2023, 9, 13), c1);

        surveyRepository.saveAll(Arrays.asList(s1, s2));

        System.out.println("Finalizado!!!");
    }
}
