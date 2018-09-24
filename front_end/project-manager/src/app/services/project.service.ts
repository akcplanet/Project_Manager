import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Project} from '../model/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private API_URL = environment.API_URL;

  constructor(private httpClient: HttpClient) {}

  public getProjects(): Observable<Project[]> {
    return this.httpClient.get<Project[]>(this.API_URL + '/project');
  }
}
