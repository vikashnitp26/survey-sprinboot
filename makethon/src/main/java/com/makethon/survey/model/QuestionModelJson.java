package com.makethon.survey.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document
public class QuestionModelJson {
    @Id
    private String questionId;
    private QuestionType questionType;
    private Object question;
   // List<QuestionModel> questionList;

}
