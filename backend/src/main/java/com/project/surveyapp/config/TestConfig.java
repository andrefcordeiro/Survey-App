package com.project.surveyapp.config;

import com.project.surveyapp.entities.Coordinator;
import com.project.surveyapp.entities.Question;
import com.project.surveyapp.entities.Survey;
import com.project.surveyapp.entities.pk.QuestionPK;
import com.project.surveyapp.repositories.CoordinatorRepository;
import com.project.surveyapp.repositories.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CoordinatorRepository coordinatorRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public void run(String... args) throws Exception {

        Coordinator c1 = new Coordinator(null, "André", "andrefc36@gmail.com",
                "andrefcordeiro", "12345");

        coordinatorRepository.save(c1);

        QuestionPK qpk1s1 = new QuestionPK((long) 1, (long) 1);
        QuestionPK qpk2s1 = new QuestionPK((long) 2, (long) 1);

        QuestionPK qpk1s2 = new QuestionPK((long) 1, (long) 2);

        Question q1s1 = new Question(qpk1s1, "How much a dollar cost?",
                "1", "infinite", "everything", "too much", "nothing");

        Question q2s1 = new Question(qpk2s1, "Where's North from here?",
                "left", "right", null, null, null);

        Set<Question> s1Questions = new HashSet<>(Arrays.asList(q1s1, q2s1));

        Question q1s2 = new Question(qpk1s2, "Look beyond the surface, don't just see what you wanna see?\n",
                "yes", "no", "idk", null, null);

        Set<Question> s2Questions = new HashSet<>(Arrays.asList(q1s1, q1s2));

        Survey s1 = new Survey(null, "Survey 1", LocalDate.of(2023, 8, 13), c1, s1Questions);
        q1s1.setSurvey(s1);
        q2s1.setSurvey(s1);
        Survey s2 = new Survey(null, "Survey 2", LocalDate.of(2023, 9, 13), c1, s2Questions);
        q1s2.setSurvey(s2);

        surveyRepository.saveAll(Arrays.asList(s1, s2));

        System.out.println("Finalizado!!!");
    }
}
