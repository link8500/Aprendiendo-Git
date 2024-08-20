import { Routes } from '@angular/router';
import { EmpleadosNewComponent } from './empleados-new/empleados-new.component';
import { HomeComponent } from './home/home.component';

export const routes: Routes = [
  { path: 'Home', component: HomeComponent },
  { path: 'New', component: EmpleadosNewComponent },
  { path: 'New/:id', component: EmpleadosNewComponent },
  { path: '', redirectTo: 'Home', pathMatch: 'full' }
];
