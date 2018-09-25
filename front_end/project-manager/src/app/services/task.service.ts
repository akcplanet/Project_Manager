import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Task} from '../model/task';

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
        'Access-Control-Allow-Methods': 'POST, GET, DELETE, PUT',
        'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept',
      })
    }
  }

  getTasks() {
    return this.httpClient.get<Task[]>(this.baseUrl + '/task');
  }

  getTaskById(id: number) {
    return this.httpClient.get<Task>(this.baseUrl + '/task/' + id);
  }

  createTask(user: Task) {
    return this.httpClient.post(this.baseUrl+ '/task', user, this.httpOptions);
  }

  updateTask(user: Task) {
    return this.httpClient.put(this.baseUrl+ '/task', user, this.httpOptions)

  }

  deleteTask(id: string) {
    return this.httpClient.delete(this.baseUrl + '/task/' + id, this.httpOptions);
  }

}
