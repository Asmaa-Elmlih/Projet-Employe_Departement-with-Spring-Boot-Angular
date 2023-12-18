package com.example.EmployeDepartement.DTO;

import com.example.EmployeDepartement.models.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String tel;
    private String cin;
    private Department departement;
}
