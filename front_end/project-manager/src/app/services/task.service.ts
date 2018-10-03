import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {TaskDTO} from '../model/task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private baseUrl = environment.API_URL;

  httpOptions;

  constructor(private httpClient: HttpClient) {

    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
         'Cache-Control': 'no-cache',
        'Access-Control-Allow-Methods': 'POST, GET, DELETE, PUT',
        'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept',
      })
    }
  }

  getTasks() {
    return this.httpClient.get<TaskDTO[]>(this.baseUrl + 'task');
  }
  
  getParentTasks() {
    return this.httpClient.get<any[]>(this.baseUrl + 'task/parent');
  }

  getTaskById(id: number) {
    return this.httpClient.get<TaskDTO>(this.baseUrl + 'task/' + id);
  }

  createTask(taskDTO: TaskDTO, flag : boolean) {
    return this.httpClient.post(this.baseUrl + 'task/'+ flag, JSON.stringify(taskDTO),  this.httpOptions);
  }

  updateTask(taskDTO: TaskDTO, flag : boolean) {
    return this.httpClient.put(this.baseUrl+ 'task/' + flag,JSON.stringify(taskDTO), this.httpOptions)
  }

  endTask(id: string) {
    return this.httpClient.put(this.baseUrl + 'task/endTask/' + id, this.httpOptions);
  }

}
