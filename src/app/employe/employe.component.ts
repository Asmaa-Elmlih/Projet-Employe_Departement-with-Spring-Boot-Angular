import { Component } from '@angular/core';
import { EmployeService } from '../services/employe.service';

@Component({
  selector: 'app-employe',
  templateUrl: './employe.component.html',
  styleUrls: ['./employe.component.css']
})
export class EmployeComponent {

  employe:InterfaceEmploye[]=[]
  constructor(private router:RouterNprivate service:EmployeService){}

  ngOnInit(){
    this.getAllEmploye();
    // this.searchEmployees();
  }
  Ajouter(){
    this.router
  }
  getAllEmploye(){
    debugger
    this.service.getAllE().subscribe(
      (res: PageResponse) => {
        this.employees = res.content; // Récupérez la liste des employés depuis la réponse paginée
      },
      (error) => {
        debugger
        console.error('Une erreur est survenue lors de la récupération des employés :', error);
      }
    );
  }

  employees: InterfaceEmploye[] = [];
  pageResponse: PageResponse | undefined;
  searchEmployees(nom?: string, prenom?: string, cin?: string, tel?: string): void {
    if (!nom && !prenom && !cin && !tel) {
      this.getAllEmploye(); // Charger tous les employés
      return;
    }
    debugger
    console.log("le nom saisie:",nom);
    this.service.getAll(nom, prenom, cin, tel).subscribe(
      
      (res: PageResponse) => {
        debugger
        console.log("le resultat cherher:",res)
        this.employees = res.content;
        this.pageResponse = res;
        debugger
        console.log(this.pageResponse)
      },
      (error) => {
        debugger
        console.error('Une erreur est survenue lors de la récupération des employés :', error);
      }
    );
  }
}

export interface InterfaceEmploye{
  id:number,
  nom:string,
  prenom:string,
  cin:string,
  tel:string,
  departmentId:any,
}
export interface PageResponse {
  content: InterfaceEmploye[];
  pageable: {
    pageNumber: number;
    pageSize: number;
    // ... d'autres attributs de pagination si nécessaires
  };
  last: boolean;
  totalPages: number;
  totalElements: number;
  size: number;
  number: number;
  sort: {
    empty: boolean;
    sorted: boolean;
    unsorted: boolean;
    // ... d'autres attributs de tri si nécessaires
  };
  first: boolean;
  numberOfElements: number;
  empty: boolean;
}
