import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Project} from '../model/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

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

  getProjects() {
    return this.httpClient.get<Project[]>(this.baseUrl + '/project');
  }

  getProjectById(id: number) {
    return this.httpClient.get<Project>(this.baseUrl + '/project/' + id);
  }

  createProject(user: Project, projectAddmanager: string) {
    return this.httpClient.post(this.baseUrl+ '/project/'+ projectAddmanager, user, this.httpOptions);
  }

  updateProject(user: Project, projectAddmanager: string) {
    return this.httpClient.put(this.baseUrl+ '/project/'+ projectAddmanager, user, this.httpOptions)

  }

  deleteProject(id: string) {
    return this.httpClient.delete(this.baseUrl + '/project/' + id, this.httpOptions);
  }

}
