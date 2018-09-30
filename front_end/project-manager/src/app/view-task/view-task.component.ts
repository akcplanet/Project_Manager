import {Component, OnInit} from '@angular/core';
import {TaskService} from '../services/task.service';
import {ProjectService} from '../services/project.service';
import {UserService} from '../services/user.service';
import {Project} from '../model/project';
import {User} from '../model/user';
import {TaskDTO} from '../model/task';

@Component({
  selector: 'app-view-task',
  templateUrl: './view-task.component.html',
  styleUrls: ['./view-task.component.css']
})
export class ViewTaskComponent implements OnInit {

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
    this.getALLTasks();
  }

  getALLTasks() {
    this.taskService.getTasks()
      .subscribe(data => {
        this.listTask = data;
      }, error => this.error);
  }


  onEditTask(editTask: TaskDTO): void {
  };

  onEndTask(endTask: TaskDTO): void {
  };


  onSortTask(value: string): void {
    this.isDesc = !this.isDesc;
    this.column = value;
    this.direction = this.isDesc ? 1 : -1;
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
