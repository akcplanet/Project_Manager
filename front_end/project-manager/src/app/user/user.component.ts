import {Component, OnInit} from '@angular/core';
import {UserService} from '../services/user.service';
import {User} from '../model/user';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  listUser: any = [];
  userAdd;
  direction: number;

  error: any;

  records: Array<User>;
  isDesc: boolean = false;
  column: string = 'UserName';

  constructor(private userService: UserService) {
    this.userAdd = new User('', '', '', '');
  }

  ngOnInit() {
    this.getAllUser();
  }

  getAllUser() {
    this.userService.getUsers()
      .subscribe(data => {
        this.listUser = data;
      }, error => this.error);
  }

  onDeleteUser(user: User): void {
    this.userService.deleteUser(null)
      .subscribe(data => {
        this.listUser = this.listUser.filter(u => u !== user);
      }, error => this.error)
  };

  onEditUser(user: User): void {
    this.userAdd = user;
  };

  onAddUser(): void {
    if (this.userAdd.userId == null) {
      this.userService.createUser(this.userAdd)
        .subscribe(data => {
          this.listUser.push(this.userAdd);
          this.userAdd = {};
        }, error => this.error);
    } else {
      this.userService.updateUser(this.userAdd)
        .subscribe(data => {
          this.getAllUser();
          this.userAdd = {};
        }, error => this.error);
    }
  };

  onUserReset(): void {
    this.userAdd = new User('', '', '', '');
  }

  onSortUser(value: string): void {
    this.isDesc = !this.isDesc;
    this.column = value;
    this.direction = this.isDesc ? 1 : -1;
  }


}
