package com.askme.askme.web.rest;

import com.askme.askme.models.Category;
import com.askme.askme.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class CategoryRestResource {

    @Autowired
    private CategoryService categoryService;

    @PostConstruct
    private void init(){
        Category c = new Category();
        c.setName("TestingOne");
        categoryService.save(c);
        c = new Category();
        c.setName("TestingTwo");
        categoryService.save(c);
        c = new Category();
        c.setName("TestingThree");
        categoryService.save(c);
        c = new Category();
        c.setName("TestingFour");
        categoryService.save(c);
        c = new Category();
        c.setName("TestingFive");
        categoryService.save(c);
        c = new Category();
        c.setName("TestingSix");
        categoryService.save(c);
        c = new Category();
        c.setName("TestingSeven");
        categoryService.save(c);


    }

    @GetMapping("/categories")
//    @PreAuthorize("isAuthenticated()")
    public List<Category> getAllCategories(){
        return  categoryService.findAll();
    }

    @GetMapping("/category/{id}")
    public Category getCategoryById(@PathVariable("id") Long id){
        return categoryService.findById(id);
    }

}
