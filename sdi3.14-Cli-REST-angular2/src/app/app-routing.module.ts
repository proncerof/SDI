import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CategoriesComponent } from "app/categories/categories.component";
import { TasksComponent } from "app/tasks/tasks.component";
import { CreateTaskComponent } from "app/create-task/create-task.component";

const routes: Routes = [
  { path: 'categories', component: CategoriesComponent },
  { path: 'categories/:id/tasks', component: TasksComponent},
  { path: 'categories/:id/task', component: CreateTaskComponent }
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
