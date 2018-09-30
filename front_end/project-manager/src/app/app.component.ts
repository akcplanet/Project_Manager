import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
   template: '<app-layout><menu></menu><router-outlet></router-outlet></app-layout>',
 // templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'project-manager';
}
