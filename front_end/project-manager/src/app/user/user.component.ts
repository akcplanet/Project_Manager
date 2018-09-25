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
  
   records: Array<User>;
  isDesc: boolean = false;
  column: string = 'CategoryName';
  
  constructor(private userService: UserService) {
    this.userAdd = new User('', '', '', '');
  }

  ngOnInit() {
    this.userService.getUsers()
      .subscribe(data => {
        this.listUser = data;
            console.log(data);
      });


  }

  onDeleteUser(user: User): void {
    console.log(user);
    this.userService.deleteUser(null)
      .subscribe(data => {
      this.listUser = this.listUser.filter(u => u !== user);
       })
  };

  onEditUser(user: User): void {
    console.log(user);
    this.userAdd = user;
  };

  onAddUser(): void {
    console.log(this.userAdd);
    if (this.userAdd.userId == null) {
      this.userService.createUser(this.userAdd)
        .subscribe(data => {
          this.listUser.push(this.userAdd);
           this.userAdd ={};
        });
    } else {
      this.userService.updateUser(this.userAdd)
        .subscribe(data => {
          this.listUser.push(this.userAdd);
           this.userAdd ={};
        });
    }
  };

  onUserReset(): void {
  this.userAdd =new User('', '', '', '');
  }

  onSortUser(value: string): void {
    console.log(value);
    this.isDesc = !this.isDesc; //change the direction    
    this.column = value;
    this.direction = this.isDesc ? 1 : -1;
  }


}
