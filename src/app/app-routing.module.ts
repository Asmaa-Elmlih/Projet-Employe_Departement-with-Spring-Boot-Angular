import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeComponent } from './employe/employe.component';
import { DepartementComponent } from './departement/departement.component';
import { AddEmployeComponent } from './add-employe/add-employe.component';

const routes: Routes = [
  {path:'employe',component:EmployeComponent},
  {path:'departement',component:DepartementComponent},
  {path:'add-employe',component:AddEmployeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes),],
  exports: [RouterModule]
})
export class AppRoutingModule { }
