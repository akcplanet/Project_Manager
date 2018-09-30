import {Component, OnInit} from '@angular/core';
import {ProjectService} from '../services/project.service';
import {UserService} from '../services/user.service';
import {Project} from '../model/project';
import {User} from '../model/user';
import * as $ from 'jquery';
import * as moment from 'moment';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {

  listProject: any = [];
  projectAddcheckbox : boolean =false;

  projectAddmanager: string;
  projectAdd;

  direction: number;
  
  allUserProject: User[] =[];

  records: Array<Project>;
  isDesc: boolean = false;
  column: string = 'CategoryName';

  constructor(private projectService: ProjectService , private userService: UserService) {
    this.projectAdd = new Project('', '', new Date(), new Date(), 0);
  }

  ngOnInit() {
    $(function() {

    }
    
    this.projectService.getProjects()
      .subscribe(data => {
        this.listProject = data;
        console.log(data);
      });
  }

  onDeleteProject(project: Project): void {
    console.log(project);
    this.projectService.deleteProject(null)
      .subscribe(data => {
        this.projectAdd = this.projectAdd.filter(u => u !== project);
      })
  };

  onEditProject(project: Project): void {
    console.log(project);
    this.projectAdd = project;
  };

  onAddProject(): void {
    console.log(this.projectAdd);
    console.log(this.projectAddmanager);
    if (this.projectAdd.userId == null) {
      this.projectService.createProject(this.projectAdd , this.projectAddmanager)
        .subscribe(data => {
          this.listProject.push(this.projectAdd);
          this.projectAdd = {};
        });
    } else {
      this.projectService.updateProject(this.projectAdd , this.projectAddmanager)
        .subscribe(data => {
          this.listProject.push(this.projectAdd);
          this.projectAdd = {};
        });
    }
  };

  onProjectReset(): void {
     this.projectAdd = new Project('', '', new Date(), new Date(), 0);
  }

  onSortProject(value: string): void {
    console.log(value);
    this.isDesc = !this.isDesc; //change the direction    
    this.column = value;
    this.direction = this.isDesc ? 1 : -1;
  }

  onAllUserSearch(){
     this.userService.getUsers()
      .subscribe(data => {
        this.allUserProject = data;
            console.log(data);
      });
  }
  
  onDateFlagChanged(input){
    console.log(input);
    if(!input){
    this.projectAdd.endDate= null;
   this.projectAdd.startDate= null;
    }
  }

}
