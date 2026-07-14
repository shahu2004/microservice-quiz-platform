package com.quiz.Controller;

import com.quiz.Entity.Quiz;
import com.quiz.Service.QuizServiceIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class Mycontroller {
    @Autowired
    QuizServiceIn quizServiceIn;

    @PostMapping("/SendData")
    public Quiz SendData(@RequestBody Quiz quiz) {
        return quizServiceIn.SendQuiz(quiz);
    }
    @GetMapping("/Getalldetails")
    public List<Quiz> GetAllDetails() {
        return quizServiceIn.findAllQuiz();

    }
    @GetMapping("/getdata/{id}")
    public Quiz GetData(@PathVariable Long id) {
        return quizServiceIn.FindQuizById(id);

    }

}
