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
  error: any;

  records: Array<TaskDTO>;
  isDesc: boolean = false;
  column: string = 'CategoryName';

  taskAddcheckbox: boolean = true;

  getAllProject: Project[] = [];
  getUserProject: User[] = [];

  constructor(private taskService: TaskService, private projectService: ProjectService, private userService: UserService) {
    this.taskAdd = new TaskDTO('', '', '', 0, '', '', '', '');
  }

  ngOnInit() {
  }


  onAddTask(): void {
    this.taskAdd.status = '';
    if (this.taskAdd.taskId == null) {
      this.taskService.createTask(this.taskAdd)
        .subscribe(data => {
          this.onTaskReset();
        }, error => this.error);
    } else {
      this.taskService.updateTask(this.taskAdd)
        .subscribe(data => {
          this.onTaskReset();
        }, error => this.error);
    }
  };

  onTaskReset(): void {
    this.taskAdd = new TaskDTO('', '', '', 0, '', '', '', '');
    this.taskAddcheckbox = true;
    this.getAllProject = [];
    this.getUserProject = [];
    this.parentTaskList = [];
  }

  
  getAllUserSearch() {
    this.userService.getUsers()
      .subscribe(data => {
        this.getUserProject = data;
      }, error => this.error);
  }

  getAllProjectSearch() {
    this.projectService.getProjects()
      .subscribe(data => {
        this.getAllProject = data;
      }, error => this.error);
  }

  getAllParentTasks() {
    this.taskService.getParentTasks()
      .subscribe(data => {
        this.parentTaskList = data;
      }, error => this.error);
  }

  onDateFlagChanged(input) {
    if (!input) {
      this.taskAdd.startDate = null;
      this.taskAdd.endDates = null;
    }
  }
}
