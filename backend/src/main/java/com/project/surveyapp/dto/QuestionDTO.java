package com.project.surveyapp.dto;

import com.project.surveyapp.entities.Question;
import jakarta.validation.constraints.NotBlank;

public class QuestionDTO {

   private Long id;

   @NotBlank(message = "question text should not be empty")
   private String text;

   @NotBlank(message = "question option1 should not be empty")
   private String option1;

   @NotBlank(message = "question option2 should not be empty")
   private String option2;

   @NotBlank(message = "question option3 should not be empty")
   private String option3;

   @NotBlank(message = "question option4 should not be empty")
   private String option4;

   @NotBlank(message = "question option5 should not be empty")
   private String option5;

   public QuestionDTO(Long id, String text, String option1, String option2, String option3, String option4, String option5) {
      this.id = id;
      this.text = text;
      this.option1 = option1;
      this.option2 = option2;
      this.option3 = option3;
      this.option4 = option4;
      this.option5 = option5;
   }

   public QuestionDTO(Question question) {
      this.id = question.getId();
      this.text = question.getText();
      this.option1 = question.getOption1();
      this.option2 = question.getOption2();
      this.option3 = question.getOption3();
      this.option4 = question.getOption4();
      this.option5 = question.getOption5();
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

   public String getOption1() {
      return option1;
   }

   public void setOption1(String option1) {
      this.option1 = option1;
   }

   public String getOption2() {
      return option2;
   }

   public void setOption2(String option2) {
      this.option2 = option2;
   }

   public String getOption3() {
      return option3;
   }

   public void setOption3(String option3) {
      this.option3 = option3;
   }

   public String getOption4() {
      return option4;
   }

   public void setOption4(String option4) {
      this.option4 = option4;
   }

   public String getOption5() {
      return option5;
   }

   public void setOption5(String option5) {
      this.option5 = option5;
   }
}
