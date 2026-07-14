package com.quiz.Service;

import com.quiz.Entity.Quiz;

import java.util.List;

public interface QuizServiceIn {

    public List<Quiz> findAllQuiz();
    public Quiz SendQuiz(Quiz quiz);
    public Quiz FindQuizById(Long id);

}
