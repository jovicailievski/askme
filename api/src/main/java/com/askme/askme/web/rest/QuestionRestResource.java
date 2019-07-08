package com.askme.askme.web.rest;

import com.askme.askme.models.*;
import com.askme.askme.service.QuestionService;
import com.askme.askme.service.UserRoleService;
import com.askme.askme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class QuestionRestResource {

    @Autowired
    private QuestionService questionService;

    //toRemove

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    private void init(){

        //toRemove
        User u = new User();
        UserRole ur = new UserRole();
        ur.setName("ROLE_ADMIN");
        userRoleService.save(ur);
        ur = new UserRole();
        ur.setName("ROLE_MEMBER");
        userRoleService.save(ur);


        ur = userRoleService.findById(2L);
        u.setUserRole(ur);
        u.setUsername("anonymous");
        u.setPassword(passwordEncoder.encode("anonymous"));
        userService.save(u);

        //----------------------

        Question q = new Question();
        q.setTitle("How to start learning programming");
        q.setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        User user = new User();
        user.setId(1l);
        q.setUser(user);
        Category c = new Category();
        c.setId(1l);
        q.setCategory(c);
        questionService.save(q);

    }

    @GetMapping("/questions")
    public List<Question> getAllQuestions(){

        return  questionService.findAll();
    }

    @GetMapping("/question/{id}")
    public Question getQuestionById(@PathVariable("id") Long id){
        return questionService.findById(id);
    }

    @GetMapping("/question/{id}/answers")
    public List<Answer> getQuestionAnswers(@PathVariable("id") Long id){
        Question q = questionService.findById(id);
        return q.getAnswers();
    }

    @PostMapping("/question")
    public Question askQUestion(@RequestBody Question question){
        User u = new User();
        u.setId(1l);
        question.setUser(u);
        return questionService.save(question);
    }
}
