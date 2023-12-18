import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { EmployeComponent } from './employe/employe.component';
import { DepartementComponent } from './departement/departement.component';
import { AddEmployeComponent } from './add-employe/add-employe.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeComponent,
    DepartementComponent,
    AddEmployeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
