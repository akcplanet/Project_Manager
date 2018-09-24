import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Task} from '../model/task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private API_URL = environment.API_URL;

  constructor(private httpClient: HttpClient) {}

  public getTasks(): Observable<Task[]> {
    return this.httpClient.get<Task[]>(this.API_URL + '/task');
  }
  
  public addTask(obj) {
    this.httpClient.post(this.API_URL + '/task', obj) .subscribe(response => console.log('Done'));
  }

}
