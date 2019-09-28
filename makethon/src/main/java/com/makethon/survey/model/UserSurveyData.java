package com.makethon.survey.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data

public class UserSurveyData {
    @Id
   private String surveyId;
   private UserDetails userDetails;
   private List<AnswerModel> allQnA;

}
