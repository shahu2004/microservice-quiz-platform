package com.Question.Service;

import com.Question.Entity.Question;

import java.util.List;

public interface QuestionServiceI {

    public List<Question> getQuestions();
    public Question getQuestion(long id);
    public Question addQuestion(Question question);
    public List<Question> getQuestionOfQuiz(Long quizId);
}
