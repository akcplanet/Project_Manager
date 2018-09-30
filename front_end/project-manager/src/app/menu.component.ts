import { Component } from '@angular/core';

@Component({
  selector: 'menu',
  template:
   `
      <ul>
          <li><a routerLink="project" routerLinkActive="active">Add Project</a></li>
          <li><a routerLink="task" routerLinkActive="active">Add Task</a></li>
          <li><a routerLink="user" routerLinkActive="active">Add User</a></li>
          <li><a routerLink="taskView" routerLinkActive="active">View Task</a></li>
      </ul>
 
  `,
  styles: [`
      :host {margin: 0; padding: 0}
      ul {list-style-type: none; padding: 0;}
      li {display: inline-block;}
      a {border: 1px solid #666666; background: #aaaaaa; border-radius: 0px; box-shadow: 1px 1px 5px black; color: white; font-weight: bold; padding: 5px; text-decoration: none}
      a.active {text-decoration: none; color: darkslategray;}
      li + li a {margin-left: 20px;}
  `]
})
export class MenuComponent {
}