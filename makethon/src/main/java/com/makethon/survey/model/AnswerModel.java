package com.makethon.survey.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerModel {
   private String questionId;
   private AnswerType answerType;
   private Object userResponse;
}
