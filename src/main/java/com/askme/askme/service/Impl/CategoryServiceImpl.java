package com.askme.askme.service.Impl;

import com.askme.askme.models.Category;
import com.askme.askme.repository.jpa.JpaCategoryRepository;
import com.askme.askme.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private JpaCategoryRepository categoryRepository;

    @Override
    public Category save(Category c) {
        return categoryRepository.save(c);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
