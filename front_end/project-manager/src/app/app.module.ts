import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { MenuComponent } from './menu.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { ProjectComponent } from './project/project.component';
import { TaskComponent } from './task/task.component';
import { UserComponent } from './user/user.component';
import { UiModule } from './ui/ui.module';

import { CategoryPipe } from './directives/category.pipe';
import { OrderrByPipe } from './directives/orderby.pipe';

@NgModule({
   bootstrap: [ AppComponent ],
 imports: [
     BrowserModule,
     HttpClientModule,
     RouterModule.forRoot([
       { path: '', redirectTo: '/project', pathMatch: 'full' },
       { path: 'project', component: ProjectComponent },
       { path: 'task', component: TaskComponent },
       { path: 'user', component: UserComponent },
       { path: 'taskView', component: TaskComponent}
     ]),
     UiModule,
     FormsModule,

 ],
 declarations: [ AppComponent, MenuComponent, ProjectComponent, TaskComponent, UserComponent , CategoryPipe, OrderrByPipe],
   providers: []
})
export class AppModule {
}