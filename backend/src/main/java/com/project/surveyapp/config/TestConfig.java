package com.project.surveyapp.config;

import com.project.surveyapp.entities.*;
import com.project.surveyapp.repositories.CoordinatorRepository;
import com.project.surveyapp.repositories.SurveyResponseRepository;
import com.project.surveyapp.repositories.RespondentRepository;
import com.project.surveyapp.repositories.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
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
    private SurveyResponseRepository surveyResponseRepository;

    @Override
    public void run(String... args) throws Exception {
        // coodinators
        Coordinator c1 = new Coordinator(null, "André", "andrefc36@gmail.com", "andrefcordeiro",
                "$2a$10$YF9rmKg5TRUnZ9JObb3czO6Y1aSpC7A6N0RaN/74Hi46R7PhAo7TG");

        Coordinator c2 = new Coordinator(null, "Pedro", "pedro@gmail.com", "pedrolol",
                "$2a$10$80eEwLxu6CuGSGZKvK/hwe4HOmFnchSx2.x4Bh0oP8QNE7sP.LVbK");

        coordinatorRepository.saveAll(Arrays.asList(c1, c2));

        // surveys

        // SURVEY 1
        Survey s1 = new Survey(null, "Survey 1", LocalDate.of(2023, 8, 13),
                Instant.parse("2019-07-21T03:42:10Z"), c1);
        // questions
        Question q1s1 = new Question(s1, "How much a dollar cost?", "1",
                "infinite", "everything", "too much", "nothing");

        Question q2s1 = new Question(s1, "Where's North from here?", "left",
                "right", null, null, null);
        s1.addQuestion(q1s1);
        s1.addQuestion(q2s1);

        // SURVEY 2
        Survey s2 = new Survey(null, "Survey 2", LocalDate.of(2023, 9, 13),
                Instant.parse("2019-07-21T03:42:10Z"), c2);

        // questions
        Question q1s2 = new Question(s2, "Look beyond the surface, don't just see what you wanna see?", "yes",
                "no", "idk", null, null);
        s2.addQuestion(q1s2);

        surveyRepository.saveAll(Arrays.asList(s1, s2));

        // respondents
        Respondent r1 = new Respondent(null, "Joao", "joao@gmail.com", "juao",
                "$2a$10$JElh.L5ZcwUURUbPOchjCeFhDaQaQVmnQNYhCRuwLJQmyXymPzioO");
        Respondent r2 = new Respondent(null, "Maria", "maria@gmail.com", "maria",
                "$2a$10$MnP6u9nnRELGKUNaAngYU.efGaQbw/Batuz4GCpmwgl8uZYNq1D5u");

        respondentRepository.saveAll(Arrays.asList(r1, r2));

        // survey response

        // survey 1 respondent 1
        SurveyResponse r1s1 = new SurveyResponse(r1, s1, Instant.parse("2019-07-21T03:42:10Z"));
        QuestionResponse rq1 = new QuestionResponse(q1s1, r1s1, 4);
        QuestionResponse rq2 = new QuestionResponse(q2s1, r1s1, 1);
        r1s1.addRespondedQuestions(Arrays.asList(rq1, rq2));

        // survey 2 respondent 1
        SurveyResponse r1s2 = new SurveyResponse(r1, s2, Instant.parse("2019-10-03T03:42:10Z"));
        QuestionResponse rq3 = new QuestionResponse(q1s1, r1s2, 3);
        r1s2.addRespondedQuestions(Arrays.asList(rq3));

        // survey 1 respondent 2
        SurveyResponse r2s1 = new SurveyResponse(r2, s1, Instant.parse("2019-07-01T03:42:10Z"));
        QuestionResponse rq4 = new QuestionResponse(q1s1, r2s1, 4);
        QuestionResponse rq5 = new QuestionResponse(q2s1, r2s1, 2);
        r2s1.addRespondedQuestions(Arrays.asList(rq4, rq5));

        surveyResponseRepository.saveAll(Arrays.asList(r1s1, r1s2, r2s1));

        System.out.println("Finalizado!!!");
    }
}
