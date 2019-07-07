package com.askme.askme.service.Impl;

import com.askme.askme.exceptions.QuestionNotFoundException;
import com.askme.askme.models.Category;
import com.askme.askme.models.Question;
import com.askme.askme.repository.jpa.JpaCategoryRepository;
import com.askme.askme.repository.jpa.JpaQuestionRepository;
import com.askme.askme.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private JpaQuestionRepository questionRepository;

    public List<Question> findAll(){
        return  questionRepository.findAll();
    }

    public Question findById(Long id){
        Optional<Question> c = questionRepository.findById(id);
        if(!c.isPresent()){
            throw new QuestionNotFoundException();
        }
        return c.get();
    }
}
