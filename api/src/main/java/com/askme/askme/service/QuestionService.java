package com.askme.askme.service;

import com.askme.askme.models.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAll();

    Question findById(Long id);
}
