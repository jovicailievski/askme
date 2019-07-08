import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../category.service';

@Component({
  selector: 'app-categoryproba',
  templateUrl: './categoryproba.component.html',
  styleUrls: ['./categoryproba.component.css']
})
export class CategoryprobaComponent implements OnInit {

  public categories=[];

  constructor( private _categoryService: CategoryService) { }

  ngOnInit() {
    this._categoryService.getCat()
    .subscribe(data => this.categories=data);
  }

}
