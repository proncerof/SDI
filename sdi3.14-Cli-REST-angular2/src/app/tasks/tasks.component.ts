import { Component, OnInit } from '@angular/core';
import { TaskService } from "app/task.service";
import { Task } from "app/task";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  categoryId:number;
  tasks:Task[];

  constructor(private service:TaskService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.categoryId = this.route.snapshot.params['id'];
    this.getTasks();
  }

  getTasks(){
    this.service.getTasks(this.categoryId).subscribe(list=>this.tasks=list);
  }

  finishTask(id:number){
    this.service.finishTask(id).subscribe(a=>this.getTasks());
  }

}
