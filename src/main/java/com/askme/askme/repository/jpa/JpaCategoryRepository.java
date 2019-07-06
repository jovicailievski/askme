package com.askme.askme.repository.jpa;

import com.askme.askme.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.PostConstruct;
import java.util.List;

public interface JpaCategoryRepository extends JpaRepository<Category,Long> {

    Category save(Category c);
    List<Category> findAll();
}
