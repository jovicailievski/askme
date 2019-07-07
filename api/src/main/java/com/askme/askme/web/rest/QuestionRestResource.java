package com.askme.askme.web.rest;

import com.askme.askme.models.Answer;
import com.askme.askme.models.Question;
import com.askme.askme.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class QuestionRestResource {

    @Autowired
    private QuestionService questionService;

//    @PostConstruct
//    private void init(){
//        Question q = new Question();
//        q.setId(1l);
//        q.setTitle("Zasto?");
//        q.setDescription("Jadi gomna");
//        Answer a = new Answer();
//        a.setId(1l);
//        a.setDescription("asdfsdfgdfg");
//        a.setQuestion(q);
//        q.getAnswers().add(a);
//    }

    @GetMapping("/questions")
    public List<Question> getAllQuestions(){
        return  questionService.findAll();
    }

    @GetMapping("/question/{id}")
    public Question getQuestionById(@PathVariable("id") Long id){
        return questionService.findById(id);
    }

//    @PostMapping("/question/ask")
//    public Question askQUestion(@RequestParam("title") String title,
//                                @RequestParam("description") String description,
//                                @RequestParam("anonymous") boolean anonymous){
//
//    }
}
