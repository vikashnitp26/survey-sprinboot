package com.makethon.survey.dao;

import com.makethon.survey.model.UserSurveyData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyFillerInterface extends MongoRepository<UserSurveyData,String> {

    List<UserSurveyData> findBySurveyId(String id);

    @Query("{'allQnA.userResponse' :{ $regex : ?0}}")
    List<UserSurveyData> findByAllQnA(String searchText);


}
