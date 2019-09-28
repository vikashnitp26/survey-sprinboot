package com.makethon.survey.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class SurveyModel {
    @Id
   private String surveyId;
   private UserDetails userDetails;
   private List<QuestionModelJson> questionModelJsonList;

}
