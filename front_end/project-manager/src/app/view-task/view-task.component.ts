import {Component, OnInit} from '@angular/core';
import {TaskService} from '../services/task.service';
import {TaskDTO} from '../model/task';
import {Router, ActivatedRoute, ParamMap} from '@angular/router';

@Component({
  selector: 'app-view-task',
  templateUrl: './view-task.component.html',
  styleUrls: ['./view-task.component.css']
})
export class ViewTaskComponent implements OnInit {

  parentTaskList: any = [];
  listTask: any = [];

  searchTask: string;

  taskend;
  taskDTO;
  taskAdd;

  direction: number;
  error: any;

  records: Array<TaskDTO>;
  isDesc: boolean = false;
  column: string = 'CategoryName';

  taskAddcheckbox: boolean = true;


  constructor(private taskService: TaskService, private route: Router) {
    this.taskAdd = new TaskDTO('', '', '', '', 0, '', '', '', '');
    this.taskend = new TaskDTO('', '', '', '', 0, '', '', '', '');
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
    this.route.navigate(['task/:editTask', editTask]);
  };

  onEndTask(endTask: TaskDTO): void {
    this.taskend = endTask;
    this.taskService.endTask(this.taskend.taskId)
      .subscribe(data => {
        this.getALLTasks();
      }, error => this.error);
  };

  onSortTask(value: string): void {
    this.isDesc = !this.isDesc;
    this.column = value;
    this.direction = this.isDesc ? 1 : -1;
  }


  onDateFlagChanged(input) {
    if (!input) {
      this.taskAdd.startDate = null;
      this.taskAdd.endDates = null;
    }
  }
}
