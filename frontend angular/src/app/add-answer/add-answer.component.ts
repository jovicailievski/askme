import { Component, OnInit } from '@angular/core';
import { IAnswer } from '../interface/answer';
import { IQuestion } from '../interface/question';

@Component({
  selector: 'app-add-answer',
  templateUrl: './add-answer.component.html',
  styleUrls: ['./add-answer.component.css']
})
export class AddAnswerComponent implements OnInit {

  answer=new IAnswer();

  constructor() 
  {
    this.answer.question=new IQuestion();
   }

  ngOnInit() {
  }

}
