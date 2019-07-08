import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../question.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-list-questions',
  templateUrl: './list-questions.component.html',
  styleUrls: ['./list-questions.component.css']
})
export class ListQuestionsComponent implements OnInit {

  questions=[];

  constructor(private questionService: QuestionService, private router: Router) { }

  ngOnInit() {
    this.questionService.getQuestions()
    .subscribe(data => this.questions=data);
  }

  onSelect(question){
       this.router.navigate(['/listquestions',question.id]);
  }

}
