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
  
  searchProject: string;

  userAddmanager: string;
  projectAdd;

  direction: number;
  
  error : any;
  
  allUserProject: User[] =[];

  records: Array<Project>;
  isDesc: boolean = false;
  column: string = 'CategoryName';

  constructor(private projectService: ProjectService , private userService: UserService) {
    this.projectAdd = new Project('', '', new Date(), new Date(), 0);
  }

  ngOnInit() {
   this.getAllProject();
  }
  
  getAllProject(){ 
     this.projectService.getProjects()
      .subscribe(data => {
        this.listProject = data;
      }, error => this.error);
  }

  onDeleteProject(project: Project): void {
    this.projectService.deleteProject(null)
      .subscribe(data => {
        this.projectAdd = this.projectAdd.filter(u => u !== project);
      }, error => this.error)
  };

  onEditProject(project: Project): void {
    this.projectAddcheckbox=true;
    this.projectAdd = project;
     this.onAllUserSearch();
  };

  onAddProject(): void {
    
    if(!this.projectAddcheckbox){
      this.projectAdd.startDate=new Date();
      let nextDay = new Date(this.projectAdd.startDate);
      nextDay.setDate(this.projectAdd.startDate.getDate()+1);
      this.projectAdd.endDate=nextDay;
    }
    if (this.projectAdd.projectId == null) {
      this.projectService.createProject(this.projectAdd , this.userAddmanager)
        .subscribe(data => {
          this.getAllProject();
          this.onProjectReset();
        }, error => this.error);
    } else {
      this.projectService.updateProject(this.projectAdd , this.userAddmanager)
        .subscribe(data => {
          this.getAllProject();
          this.onProjectReset();
        }, error => this.error);
    }
  };

  onProjectReset(): void {
     this.projectAdd = new Project('', '', new Date(), new Date(), 0);
     this.projectAddcheckbox= false;;
    this.allUserProject=[];
  }

  onSortProject(value: string): void {
    this.isDesc = !this.isDesc; 
    this.column = value;
    this.direction = this.isDesc ? 1 : -1;
  }

  onAllUserSearch(){
     this.userService.getUsers()
      .subscribe(data => {
        this.allUserProject = data;
      }, error => this.error);
  }
  
  onDateFlagChanged(input){
    if(!input){
    this.projectAdd.endDate= null;
   this.projectAdd.startDate= null;
    }
  }

}
