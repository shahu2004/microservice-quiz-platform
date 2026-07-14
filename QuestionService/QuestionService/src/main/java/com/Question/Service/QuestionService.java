package com.Question.Service;

import com.Question.Entity.Question;
import com.Question.Repositroy.QuestionRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements QuestionServiceI  {
    @Autowired
    QuestionRepositroy  questionRepositroy  ;
    @Override
    public List<Question> getQuestions() {
        return questionRepositroy.findAll();
    }

    @Override
    public Question getQuestion(long id) {
        return questionRepositroy.findById(id).get();
    }

    @Override
    public List<Question> getQuestionOfQuiz(Long quizId) {
        return questionRepositroy.findByQuizId(quizId);
    }

    @Override
    public Question addQuestion(Question question) {
        return questionRepositroy.save(question);
    }
}
