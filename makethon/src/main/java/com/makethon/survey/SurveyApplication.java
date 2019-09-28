package com.makethon.survey;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.makethon.survey.Service.SurveyService;
import com.makethon.survey.controller.SurveyController;
import com.makethon.survey.dao.SurveyCreatorInterface;
import com.makethon.survey.dao.SurveyFillerInterface;
import com.makethon.survey.model.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.util.FileSystemUtils;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {SurveyFillerInterface.class, SurveyCreatorInterface.class})

public class SurveyApplication {

    public static void main(String[] args) throws IOException {


        ConfigurableApplicationContext appcontext = SpringApplication.run(SurveyApplication.class, args);
/*        ClassLoader classLoader = new SurveyApplication().getClass().getClassLoader();
        File file = new File(classLoader.getResource("download.jpg").getFile());
        byte[] bytes = Files.readAllBytes(file.toPath());

        ImageQuestion build = ImageQuestion.builder().questionImage(bytes).questionString("How's she?").build();
        QuestionModelJson imageQuestion = QuestionModelJson.builder().question("Question 1 ")
                .questionType(QuestionType.IMAGE).question(build).build();

        TextRadioQuestion radioQ = TextRadioQuestion.builder().questionString("Radio Question").ResponseChoices(Arrays.asList("1", "2", "3")).build();
        QuestionModelJson question3 = QuestionModelJson.builder().question(radioQ)
                .questionType(QuestionType.RADIO).build();
        List<QuestionModelJson> questionList = new ArrayList<>();

        QuestionModelJson questionModelJson1 = QuestionModelJson.builder().questionId(UUID.randomUUID().toString()).question("Question 3 ")
                .questionType(QuestionType.TEXT).build();

        questionList.add(imageQuestion);
        questionList.add(question3);
        questionList.add(questionModelJson1);
        SurveyController bean = appcontext.getBean(SurveyController.class);
        SurveyCreatorData surveyCreatorData = SurveyCreatorData.builder().surveyId(UUID.randomUUID().toString())
                .allQuestions(questionList).surveyor(Surveyor.builder().organizationName("Google").build()).build();

        PodamFactory podamFactory = new PodamFactoryImpl();
        UserSurveyData userSurveyData = podamFactory.manufacturePojoWithFullData(UserSurveyData.class);
        List<AnswerModel> allQnA = userSurveyData.getAllQnA();
        for (AnswerModel answerModel : allQnA) {
           answerModel.setAnswerType(AnswerType.TEXT);
            answerModel.setUserResponse("bytes");
        }
        SurveyCreatorData surveyCreatorData1 = podamFactory.manufacturePojo(SurveyCreatorData.class);

        List<QuestionModelJson> allQuestions = surveyCreatorData1.getAllQuestions();
        for (QuestionModelJson allQuestion : allQuestions) {
            allQuestion.setQuestion("RADIO,TEXT,RATING,IMAGE,AV");

        }
        allQuestions.get(0).setQuestionType(QuestionType.RADIO);
        allQuestions.get(0).setQuestion(radioQ);
        String s = new ObjectMapper().writeValueAsString(surveyCreatorData);



     //   bean.insertData(userSurveyData);
       List<SurveyCreatorData> allSurveys = bean.getAllSurveys();
       System.out.println(new ObjectMapper().writeValueAsString(allSurveys));
        System.out.println(new ObjectMapper().writeValueAsString(bean.getSurvey("zZLDcoFefV")));
        List<UserSurveyData> userResponsesForSurvey = bean.getUserResponsesForSurvey(userSurveyData.getSurveyId());
        System.out.println(new ObjectMapper().writeValueAsString(userResponsesForSurvey));*/
    }

}
