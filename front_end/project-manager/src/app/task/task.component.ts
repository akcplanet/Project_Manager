import {Component, OnInit} from '@angular/core';
import {TaskService} from '../services/task.service';
import {Task} from '../model/task';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {


  listTask: any = [];

  taskAdd;

  direction: number;

  records: Array<Task>;
  isDesc: boolean = false;
  column: string = 'CategoryName';

  constructor(private taskService: TaskService, ) {
    this.taskAdd = new Task('');
  }

  ngOnInit() {
    this.taskService.getTasks()
      .subscribe(data => {
        this.listTask = data;
            console.log(data);
      });


  }

  onDeleteUser(user: Task): void {
    console.log(user);
    this.taskService.deleteTask(null)
      .subscribe(data => {
        this.listTask = this.listTask.filter(u => u !== user);
      })
  };

  onEditUser(user: Task): void {
    console.log(user);
    this.taskAdd = user;
  };

  onAddUser(): void {
    console.log(this.taskAdd);
    if (this.taskAdd.userId == null) {
      this.taskService.createTask(this.taskAdd)
        .subscribe(data => {
          this.listTask.push(this.taskAdd);
          this.taskAdd = {};
        });
    } else {
      this.taskService.updateTask(this.taskAdd)
        .subscribe(data => {
          this.listTask.push(this.taskAdd);
          this.taskAdd = {};
        });
    }
  };

  onUserReset(): void {
    this.taskAdd = new Task('');
  }

  onSortUser(value: string): void {
    console.log(value);
    this.isDesc = !this.isDesc; //change the direction    
    this.column = value;
    this.direction = this.isDesc ? 1 : -1;
  }


}
