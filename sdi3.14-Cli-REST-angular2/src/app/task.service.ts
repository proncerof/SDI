import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from "@angular/http";
import { Observable } from "rxjs/Observable";
import { Category } from "app/category";
import "rxjs/Rx";
import { Task } from "app/task";
import { Subject } from "rxjs/Subject";


@Injectable()
export class TaskService {

  url: string = "http://localhost:8280/sdi3-14.Web/rest/TaskServiceRs/";
  id;
  username: string;
  password: string;

  constructor(private http: Http, public subject: Subject<any>) {
  }

  getUserId(username: string, password: string) {
    this.username = username;
    this.password = password;
    var url = this.url + "login";
    let headers: Headers = new Headers();
    headers.append('Authorization', 'Basic ' + btoa(this.username + ":" + this.password));

    this.http.get(url, { headers: headers }).map(res => { return res.text() }).subscribe(id => { this.id = id; this.showCategories();  });
  }

  getCategories(): Observable<Category[]> {
    var url: string = this.url + "users/" + this.id + "/categories"

    let headers: Headers = new Headers();
    headers.append('Authorization', 'Basic ' + btoa(this.username + ":" + this.password));

    return this.http.get(url, { headers: headers }).
      map(this.parseCategory).
      catch(this.handleError);
  }

  private parseCategory(res: Response): Category[] {
    var categories: Category[] = [];
    for (let result of res.json()) {
      categories.push(new Category(result["id"], result["name"]))
    }
    return categories;
  }

  getTasks(id: number): Observable<Task[]> {
    var url: string = this.url + "users/" + this.id + "/categories/" + id + "/tasks";

    let headers: Headers = new Headers();
    headers.append('Authorization', 'Basic ' + btoa(this.username + ":" + this.password));

    return this.http.get(url, { headers: headers }).
      map(this.parseTask).
      catch(this.handleError);
  }

  private parseTask(res: Response): Task[] {
    var tasks: Task[] = [];
    for (let result of res.json()) {
      tasks.push(new Task(result["id"], result["title"], result["created"], result["planned"]));
    }
    return tasks;
  }

  public finishTask(id: number): Observable<any> {
    var url: string = this.url + "users/" + this.id + "/tasks/" + id;

    let headers: Headers = new Headers();
    headers.append('Authorization', 'Basic ' + btoa(this.username + ":" + this.password));

    return this.http.put(url, "", { headers: headers });
  }

  public createTask(task: Task, id:number) {
    var url: string = this.url + "users/"+this.id+"/categories/"+id+"/tasks";

     let headers: Headers = new Headers();
    headers.append('Authorization', 'Basic ' + btoa(this.username + ":" + this.password));

    this.http.post(url, task, {headers:headers}).subscribe();
  }

  showCategories(){
    this.subject.next();
  }

  private handleError(error: Response | any) {
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);


  }

}
