package com.Question.Controller;

import com.Question.Entity.Question;
import com.Question.Service.QuestionServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class Mycontroller {

    @Autowired
    QuestionServiceI questionService;

    @GetMapping("/getdata")
    public List<Question> getQuestions() {
        return questionService.getQuestions();
    }
    @GetMapping("/get/{id}")
    public Question getQuestion(@PathVariable long id) {
        return questionService.getQuestion(id);
    }
    @PostMapping("/postdata")
    public Question postQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }
    @GetMapping("/getrecord/{quizId}")
    public List<Question> getRecord(@PathVariable Long quizId) {
        return questionService.getQuestionOfQuiz(quizId);
    }

}
