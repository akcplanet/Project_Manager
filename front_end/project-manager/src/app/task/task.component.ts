import {Component, OnInit} from '@angular/core';
import {TaskService} from '../services/task.service';
import {ProjectService} from '../services/project.service';
import {UserService} from '../services/user.service';
import {Project} from '../model/project';
import {User} from '../model/user';
import {TaskDTO} from '../model/task';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {
  
  parentTaskList: any = [];
  listTask: any = [];

  taskAdd;
  taskDTO;

  direction: number;

  records: Array<TaskDTO>;
  isDesc: boolean = false;
  column: string = 'CategoryName';
  
    getAllProject: Project[] =[];  
    getUserProject: User[] =[];

  constructor(private taskService: TaskService,private projectService: ProjectService , private userService: UserService ) {
    this.taskAdd = new TaskDTO('', '', '', 0, '', '', '', '');
  }

  ngOnInit() {
    this.taskService.getTasks()
      .subscribe(data => {
        this.listTask = data;
        console.log(data);
      });
  }

  onDeleteTaskr(user: TaskDTO): void {
    console.log(user);
    this.taskService.deleteTask(null)
      .subscribe(data => {
        this.listTask = this.listTask.filter(u => u !== user);
      })
  };

  onEditTask(user: TaskDTO): void {
    console.log(user);
    this.taskAdd = user;
  };

  onAddTask(): void {
    this.taskAdd.status = '';
    if (this.taskAdd.userId != null) {
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

  onTaskReset(): void {
    this.taskAdd = new TaskDTO('', '', '', 0, '', '', '', '');
  }

  onSortTask(value: string): void {
    console.log(value);
    this.isDesc = !this.isDesc; //change the direction    
    this.column = value;
    this.direction = this.isDesc ? 1 : -1;
  }

   getAllUserSearch(){
     this.userService.getUsers()
      .subscribe(data => {
        this.getUserProject = data;
            console.log(data);
      });
  }
  
   getAllProjectSearch(){
    this.projectService.getProjects()
      .subscribe(data => {
        this.getAllProject = data;
        console.log(data);
      });
  }
  
     getAllParentTasks(){
    this.taskService.getParentTasks()
      .subscribe(data => {
        this.parentTaskList = data;
        console.log(data);
      });
  }
  
  
    onDateFlagChanged(input){
    console.log(input);
    if(!input){
    this.taskAdd.startDate= null;
   this.taskAdd.endDates= null;
    }
  }
}
