package com.project.surveyapp.config;

import com.project.surveyapp.entities.*;
import com.project.surveyapp.repositories.CoordinatorRepository;
import com.project.surveyapp.repositories.RespondedSurveyRepository;
import com.project.surveyapp.repositories.RespondentRepository;
import com.project.surveyapp.repositories.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.*;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CoordinatorRepository coordinatorRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private RespondentRepository respondentRepository;

    @Autowired
    private RespondedSurveyRepository respondedSurveyRepository;

    @Override
    public void run(String... args) throws Exception {
        // coodinators
        Coordinator c1 = new Coordinator(null, "André", "andrefc36@gmail.com",
                "andrefcordeiro", "12345");

        coordinatorRepository.save(c1);

        // surveys
        Survey s1 = new Survey(null, "Survey 1", LocalDate.of(2023, 8, 13), c1);
        Survey s2 = new Survey(null, "Survey 2", LocalDate.of(2023, 9, 13), c1);

        // questions
        Question q1s1 = new Question(s1, "How much a dollar cost?",
                "1", "infinite", "everything", "too much", "nothing");

        Question q2s1 = new Question(s1, "Where's North from here?",
                "left", "right", null, null, null);

        Question q1s2 = new Question(s2, "Look beyond the surface, don't just see what you wanna see?\n",
                "yes", "no", "idk", null, null);

        s1.addQuestions(Arrays.asList(q1s1, q2s1));
        s2.addQuestions(List.of(q1s2));

        surveyRepository.saveAll(Arrays.asList(s1, s2));

        // respondents
        Respondent r1 = new Respondent(null, "Joao", "joao@gmail.com", "juao", "1234");
        Respondent r2 = new Respondent(null, "Maria", "maria@gmail.com", "maria", "123");

        respondentRepository.saveAll(Arrays.asList(r1, r2));

        // responded
        RespondedSurvey r1s1 = new RespondedSurvey(r1, s1, new Date());
        RespondedSurvey r1s2 = new RespondedSurvey(r1, s2, new Date());

        RespondedSurvey r2s1 = new RespondedSurvey(r2, s1, new Date());

        // responded question
        RespondedQuestion rq1 = new RespondedQuestion(q1s1, r1s1, 4);
        r1s1.addRespondedQuestions(Arrays.asList(rq1));

        respondedSurveyRepository.saveAll(Arrays.asList(r1s1, r1s2, r2s1));

        System.out.println("Finalizado!!!");
    }
}
