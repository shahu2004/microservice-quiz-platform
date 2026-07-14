package com.quiz.Service;

import com.quiz.Entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "QUESTIONSERVICE")
public interface QuestionClient {

    @GetMapping("/question/getrecord/{quizId}")
    List<Question> getQuestionsofquiz(@PathVariable Long quizId);
}
