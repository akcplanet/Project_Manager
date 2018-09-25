import {Component, OnInit} from '@angular/core';
import {ProjectService} from '../services/project.service';
import {Project} from '../model/project';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {

  listProject: any = [];


  projectAdd;

  direction: number;

  records: Array<Project>;
  isDesc: boolean = false;
  column: string = 'CategoryName';

  constructor(private projectService: ProjectService) {
    this.projectAdd = new Project('', '', '', '', 0);
  }

  ngOnInit() {
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
    if (this.projectAdd.userId == null) {
      this.projectService.createProject(this.projectAdd)
        .subscribe(data => {
          this.listProject.push(this.projectAdd);
          this.projectAdd = {};
        });
    } else {
      this.projectService.updateProject(this.projectAdd)
        .subscribe(data => {
          this.listProject.push(this.projectAdd);
          this.projectAdd = {};
        });
    }
  };

  onProjectReset(): void {
    this.projectAdd =new Project('', '', '', '', 0);
  }

  onSortProject(value: string): void {
    console.log(value);
    this.isDesc = !this.isDesc; //change the direction    
    this.column = value;
    this.direction = this.isDesc ? 1 : -1;
  }


}
