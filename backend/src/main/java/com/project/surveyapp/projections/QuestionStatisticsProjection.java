package com.project.surveyapp.projections;

public interface QuestionStatisticsProjection {
    Long getQuestionId();

    String getOptions();

    String getOptionsNumberOfSelections();
}
