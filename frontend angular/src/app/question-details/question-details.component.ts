import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router, ParamMap} from '@angular/router';
import { from } from 'rxjs';
import { FnParam } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-question-details',
  templateUrl: './question-details.component.html',
  styleUrls: ['./question-details.component.css']
})
export class QuestionDetailsComponent implements OnInit {

  questionId:number;


  constructor( private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
   // this.questionId= parseInt(this.route.snapshot.paramMap.get('id')); //zimame id od question
   this.route.paramMap.subscribe((params: ParamMap)=>{
     let id=parseInt(params.get('id'));
     this.questionId=id;
   });
  }

  goPrevious(){
   let previousId=this.questionId-1;
   this.router.navigate(['listquestions', previousId]);

  }

  goNext(){

    let nextId=this.questionId+1;
    this.router.navigate(['listquestions', nextId]);
 
  }
  goToQuestionsList(){
    let selectedId=this.questionId ? this.questionId : null;
    this.router.navigate(['listquestions', {id:selectedId}]);

  }

}
