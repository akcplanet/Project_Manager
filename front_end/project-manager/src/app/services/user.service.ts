import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
//import {Observable} from 'rxjs/Observable';
import {User} from '../model/user';


@Injectable({
  providedIn: 'root'
})
export class UserService {

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

  getUsers() {
    return this.httpClient.get<User[]>(this.baseUrl + '/user');
  }

  getUserById(id: number) {
    return this.httpClient.get<User>(this.baseUrl + '/user/' + id);
  }

  createUser(user: User) {
    return this.httpClient.post(this.baseUrl+ '/user', user, this.httpOptions);
  }

  updateUser(user: User) {
    return this.httpClient.put(this.baseUrl+ '/user', user, this.httpOptions)

  }

  deleteUser(id: string) {
    return this.httpClient.delete(this.baseUrl + '/user/' + id, this.httpOptions);
  }

}
