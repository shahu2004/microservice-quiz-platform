package com.quiz.Service;

import com.quiz.Entity.Quiz;
import com.quiz.Repositroy.QuizRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService implements QuizServiceIn {

    QuizRepositroy  quizRepositroy;
    QuestionClient questionClient;

    @Override
    public List<Quiz> findAllQuiz() {

        List<Quiz> quiz = quizRepositroy.findAll();

        List<Quiz> newQuizList = quiz.stream()
                .map(q -> {
                    q.setQuestions(questionClient.getQuestionsofquiz(q.getId()));
                    return q;
                })
                .collect(Collectors.toList());

        return newQuizList;
    }
    @Override
    public Quiz SendQuiz(Quiz quiz) {
        return quizRepositroy.save(quiz);
    }
    @Override
    public Quiz FindQuizById(Long id) {
        Quiz quiz=quizRepositroy.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found with id: " + id));
        quiz.setQuestions(questionClient.getQuestionsofquiz(quiz.getId()));
        return quiz;
    }

    @Autowired
    public QuizService(QuestionClient questionClient, QuizRepositroy quizRepositroy) {
        this.questionClient = questionClient;
        this.quizRepositroy = quizRepositroy;
    }
}
