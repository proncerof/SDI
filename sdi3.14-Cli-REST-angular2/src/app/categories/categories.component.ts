import { Component, OnInit } from '@angular/core';
import { Category } from "app/category";
import { TaskService } from "app/task.service";

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  private categories: Category[];

  constructor(private service: TaskService) { }

  ngOnInit() {
    this.service.subject.subscribe(a=>this.getCategories());
  }

  getCategories() {
    this.service.getCategories().subscribe(list => this.categories = list);
  }

}
