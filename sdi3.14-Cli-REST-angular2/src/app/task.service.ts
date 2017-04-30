import { Injectable } from '@angular/core';
import { Http , Headers, RequestOptions, Response } from "@angular/http";
import { Observable } from "rxjs/Observable";
import { Category } from "app/category";
import "rxjs/Rx";
import { Task } from "app/task";


@Injectable()
export class TaskService {

  url:string = "http://localhost:8280/sdi3-14.Web/rest/TaskServiceRs/";

  constructor(private http:Http) {
   }

  getCategories():Observable<Category[]>{
    var url:string = this.url+"users/5015/categories"
    
    let username: string = "user1";
      let password: string = "user1";
      let headers: Headers = new Headers();
      headers.append("Authorization", "Basic " + btoa(username +":"+ password));

      var options:RequestOptions = new RequestOptions({headers:headers});

    return this.http.get(url,options).
            map(this.parseCategory).
            catch(this.handleError);
  }

  private parseCategory(res:Response):Category[]{
    var categories: Category[] = [];
    for(let result of res.json()){
      categories.push(new Category(result["id"],result["name"]))
    }
    return categories;
  }

  getTasks(id:number):Observable<Task[]>{
    var url:string = this.url+"categories/"+id+"/tasks";
    
    return this.http.get(url).
            map(this.parseTask).
            catch(this.handleError);
  }

  private parseTask(res:Response):Task[]{
    var tasks: Task[] = [];
    for(let result of res.json()){
      tasks.push(new Task(result["id"],result["title"],result["created"],result["planned"],result["retarded"]));
    }
    return tasks;
  }

  public finishTask(id:number){
    var url:string = this.url+"tasks/"+id;
    this.http.post(url,"").subscribe();
  }

 public createTask(task:Task){
   var url:string = this.url+"tasks";
   this.http.post(url,task).subscribe();
 }

  private handleError(error : Response | any){
    let errMsg : string;
    if(error instanceof Response){
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body); 
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    }else{
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);


  }

}
