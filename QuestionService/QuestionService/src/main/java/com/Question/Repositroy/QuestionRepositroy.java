package com.Question.Repositroy;

import com.Question.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepositroy extends JpaRepository<Question, Long> {

    public List<Question>findByQuizId(Long quizId);
}
