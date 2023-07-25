package com.project.surveyapp.dto;

import com.project.surveyapp.entities.Question;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Arrays;
import java.util.List;

public class QuestionDTO {

  private Long id;

  @NotBlank(message = "question text should not be empty")
  private String text;

  @NotEmpty(message = "question options should not be empty")
  private List<String> options;

  public QuestionDTO(Long id, String text, List<String> options) {
    this.id = id;
    this.text = text;
    this.options = options;
  }

  public QuestionDTO(Question question) {
    this.id = question.getId();
    this.text = question.getText();
    this.options =
        Arrays.asList(
            question.getOption1(),
            question.getOption2(),
            question.getOption3(),
            question.getOption4(),
            question.getOption5());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public List<String> getOptions() {
    return options;
  }

  public void setOptions(List<String> options) {
    this.options = options;
  }
}
