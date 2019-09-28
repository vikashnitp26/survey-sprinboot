package com.makethon.survey.controller;

import com.makethon.survey.Service.SurveyService;
import com.makethon.survey.model.AnswerModel;
import com.makethon.survey.model.QuestionModelJson;
import com.makethon.survey.model.SurveyCreatorData;
import com.makethon.survey.model.UserSurveyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/")
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    @PostMapping("insert")
    public void insertData(@RequestBody SurveyCreatorData surveyCreatorData) {
        surveyService.insertData(surveyCreatorData);
    }

    @GetMapping("getAllSurveys")
    public List<SurveyCreatorData> getAllSurveys() {
        return surveyService.getSurveys();
    }


    @GetMapping("get-survey/{id}")
    public SurveyCreatorData getSurvey(@PathVariable(name = "id") String id) {
        return surveyService.getSurveyById(id);
    }

    @PostMapping("user-response")
    public void insertData(@RequestBody UserSurveyData userSurveyData) {
        surveyService.insertUserResponseData(userSurveyData);
    }

    @GetMapping("get-user-responses/{id}")
    public List<UserSurveyData> getUserResponsesForSurvey(@PathVariable(name = "id") String id) {
        return surveyService.getUserResponsesForSurveyId(id);
    }

    @GetMapping("get-user-responses")
    public List<UserSurveyData> getUserResponses() {
        return surveyService.getUserResponses();
    }

    @GetMapping("{searchText}/find-questions")
    public List<QuestionModelJson> getQuestionWithResponses(@PathVariable(name = "searchText") String searchText){
        return surveyService.getQuestionsWithResponse(searchText);
    }

    @GetMapping("{searchText}/find-responses")
    public List<AnswerModel> getResponsesForQuestions(@PathVariable(name = "searchText") String searchText){
        return surveyService.getResponsesForQuestions(searchText);
    }

}

