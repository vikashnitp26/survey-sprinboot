package com.makethon.survey.Service;

import com.makethon.survey.dao.SurveyCreatorInterface;
import com.makethon.survey.dao.SurveyFillerInterface;
import com.makethon.survey.model.AnswerModel;
import com.makethon.survey.model.QuestionModelJson;
import com.makethon.survey.model.SurveyCreatorData;
import com.makethon.survey.model.UserSurveyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurveyService {

    @Autowired
    private SurveyCreatorInterface surveyCreatorInterface;
    @Autowired
    private SurveyFillerInterface surveyFillerInterface;


    public void insertData(SurveyCreatorData surveyCreatorData) {
            surveyCreatorInterface.insert(surveyCreatorData);
    }
    public List<SurveyCreatorData> getSurveys() {
        return surveyCreatorInterface.findAll();
    }

    public SurveyCreatorData getSurveyById(String id) {
        return surveyCreatorInterface.findBySurveyId(id);
    }

    public void insertUserResponseData(UserSurveyData userSurveyData) {
        surveyFillerInterface.insert(userSurveyData);
    }
    public List<UserSurveyData> getUserResponsesForSurveyId(String id) {
        return surveyFillerInterface.findBySurveyId(id);
    }

    public List<UserSurveyData> getUserResponses() {
        return surveyFillerInterface.findAll();
    }

    public List<QuestionModelJson> getQuestionsWithResponse(String searchText) {
        List<QuestionModelJson> questionList = new ArrayList<>();

        List<UserSurveyData> userSurveyDataList = surveyFillerInterface.findByAllQnA(searchText);

        for (UserSurveyData userSurveyData:userSurveyDataList) {

            List<AnswerModel> answerModels=userSurveyData.getAllQnA().stream().
                    filter(answerModel -> answerModel.getUserResponse().toString().contains(searchText)).collect(Collectors.toList());

            List<QuestionModelJson> questionModelJsons = new ArrayList<>();
            for(SurveyCreatorData surveyCreatorData:getSurveys()){
                   questionModelJsons.addAll(surveyCreatorData.getAllQuestions());
            }

            for(AnswerModel answerModel: answerModels){
               questionList.addAll( questionModelJsons.stream().filter(questionModelJson -> questionModelJson.getQuestionId().contentEquals(answerModel.getQuestionId()))
                        .collect(Collectors.toList()));
            }
        }

        return questionList;
    }

    public List<AnswerModel> getResponsesForQuestions(String searchText) {
        List<AnswerModel> answerModelList = new ArrayList<>();

        List<SurveyCreatorData> userSurveyDataList = surveyCreatorInterface.findByAllQuestions(searchText);

        for (SurveyCreatorData surveyCreatorData1:userSurveyDataList) {

            List<QuestionModelJson> questionModelJsons=surveyCreatorData1.getAllQuestions().stream().
                    filter(questionModelJson -> questionModelJson.getQuestion().toString().contains(searchText)).collect(Collectors.toList());

            List<AnswerModel> answerModels = new ArrayList<>();
            for(UserSurveyData userSurveyData:getUserResponses()){
                answerModels.addAll(userSurveyData.getAllQnA());
            }

            for(QuestionModelJson questionModelJson: questionModelJsons){
                answerModelList.addAll( answerModels.stream().filter(answerModel -> answerModel.getQuestionId().contentEquals(questionModelJson.getQuestionId()))
                        .collect(Collectors.toList()));
            }
        }

        return answerModelList;    }
}
