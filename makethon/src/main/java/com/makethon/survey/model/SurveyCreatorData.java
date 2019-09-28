package com.makethon.survey.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "CompleteSurvey")
@JsonAutoDetect
public class SurveyCreatorData {
    @Id
   private String surveyId;
   private Surveyor surveyor;
   private List<QuestionModelJson> allQuestions;
}
