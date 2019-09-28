package com.makethon.survey.dao;

import com.makethon.survey.model.QuestionModelJson;
import com.makethon.survey.model.SurveyCreatorData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyCreatorInterface extends MongoRepository<SurveyCreatorData,String> {

    SurveyCreatorData findBySurveyId(String surveyId);

    @Query("{'allQuestions.question' :{ $regex : ?0}}")
    List<SurveyCreatorData> findByAllQuestions(String searchText);

}

