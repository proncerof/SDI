import { Component, OnInit } from '@angular/core';
import { Task } from "app/task";
import { TaskService } from "app/task.service";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-create-task',
  templateUrl: './create-task.component.html',
  styleUrls: ['./create-task.component.css']
})
export class CreateTaskComponent implements OnInit {
  title: string;
  planned: Date;
  categoryId:number;

  constructor(private service: TaskService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.categoryId = this.route.snapshot.params['id'];
  }

  createTask() {
    var task: Task = new Task(undefined, this.title, undefined, this.planned);
    this.service.createTask(task, this.categoryId);
  }

}
