import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { CategoriesComponent } from './categories/categories.component';
import { TaskService } from "app/task.service";
import { TasksComponent } from './tasks/tasks.component';
import { CreateTaskComponent } from './create-task/create-task.component';
import { LoginComponent } from './login/login.component';
import { Subject } from "rxjs/Subject";
import { AppRoutingModule } from "app/app-routing.module";

@NgModule({
  declarations: [
    AppComponent,
    CategoriesComponent,
    TasksComponent,
    CreateTaskComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [TaskService, Subject],
  bootstrap: [AppComponent]
})
export class AppModule { }
