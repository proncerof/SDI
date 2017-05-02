import { Component, OnInit, ViewChild } from '@angular/core';
import { TaskService } from "app/task.service";
import { CategoriesComponent } from "app/categories/categories.component";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @ViewChild(CategoriesComponent)
  categories: CategoriesComponent;

  username:string;
  password:string;

  constructor(private service:TaskService) { }

  ngOnInit() {
  }

  login(){
    this.service.getUserId(this.username, this.password);
  }
}
