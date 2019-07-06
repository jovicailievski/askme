package com.askme.askme.web.rest;

import com.askme.askme.models.Answer;
import com.askme.askme.models.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class QuestionRestResource {

    private List<Question> questionList;

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
    private List<Question> getAllQuestions(){
        return questionList;
    }
}
