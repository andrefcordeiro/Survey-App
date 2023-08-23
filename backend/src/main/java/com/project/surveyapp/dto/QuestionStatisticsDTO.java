package com.project.surveyapp.dto;

import com.project.surveyapp.projections.QuestionStatisticsProjection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuestionStatisticsDTO {

    private Long questionId;

    private String text;

    private List<OptionSelectionCount> optionSelectionCounts = new ArrayList<>();

    public QuestionStatisticsDTO() {
    }

    public QuestionStatisticsDTO(QuestionDTO q, QuestionStatisticsProjection projection) {
        this.text = q.getText();
        this.questionId = projection.getQuestionId();

        if (projection.getOptions() != null) {

            String[] options = projection.getOptions().split(",");
            String[] optionsNumberOfSelections = projection.getOptionsNumberOfSelections().split(",");

            for (int i = 0; i < options.length; i++) {
                this.optionSelectionCounts.add(new OptionSelectionCount(Integer.parseInt(options[i]),
                        Long.parseLong(optionsNumberOfSelections[i])));
            }
        }
    }

    public class OptionSelectionCount {

        private Integer optionNumber;

        private Long numberOfSelections;

        public OptionSelectionCount() {
        }

        public OptionSelectionCount(Integer optionNumber, Long numberOfSelections) {
            this.optionNumber = optionNumber;
            this.numberOfSelections = numberOfSelections;
        }

        public Integer getOptionNumber() {
            return optionNumber;
        }

        public void setOptionNumber(Integer optionNumber) {
            this.optionNumber = optionNumber;
        }

        public Long getNumberOfSelections() {
            return numberOfSelections;
        }

        public void setNumberOfSelections(Long numberOfSelections) {
            this.numberOfSelections = numberOfSelections;
        }
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<OptionSelectionCount> getOptionSelectionCounts() {
        return optionSelectionCounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionStatisticsDTO that = (QuestionStatisticsDTO) o;
        return Objects.equals(questionId, that.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId);
    }
}
