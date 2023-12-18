import { Component } from '@angular/core';
import { EmployeService } from '../services/employe.service';
import { InterfaceEmploye } from '../employe/employe.component';

@Component({
  selector: 'app-add-employe',
  templateUrl: './add-employe.component.html',
  styleUrls: ['./add-employe.component.css']
})
export class AddEmployeComponent {

  newEmployee: InterfaceEmploye = {
    id:0,
    nom: '',
    prenom: '',
    tel: '',
    cin: '',
    departmentId:0
    // Ajoutez d'autres propriétés ici
  };

  constructor(private service:EmployeService){}

  addEmploye(){
    this.service.add(this.newEmployee).subscribe(
      (res: any) => {
        console.log('Employé ajouté avec succès :', res);
        // Réinitialisez le formulaire ou effectuez d'autres actions nécessaires après l'ajout
        this.newEmployee = {
          id:0,
          nom: '',
          prenom: '',
          tel: '',
          cin: '',
          departmentId:0
          // Réinitialisez les autres propriétés si nécessaire
        };
      },
      (error) => {
        console.error('Erreur lors de l\'ajout de l\'employé :', error);
      }
    );
  }
}
