import { Component, OnInit } from '@angular/core';
import { Task } from "app/task";
import { TaskService } from "app/task.service";

@Component({
  selector: 'app-create-task',
  templateUrl: './create-task.component.html',
  styleUrls: ['./create-task.component.css']
})
export class CreateTaskComponent implements OnInit {

  title:string;
  planned:Date
 
  constructor(private service:TaskService) { }

  ngOnInit() {
  }

  createTask(){
    var task:Task = new Task(undefined,this.title,undefined,this.planned);
    this.service.createTask(task);
  }

}
