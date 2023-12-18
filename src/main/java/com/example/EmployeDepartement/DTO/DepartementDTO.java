package com.example.EmployeDepartement.DTO;

import com.example.EmployeDepartement.models.Employe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartementDTO {
    private Long id;
    private String libelle;
    private String description;
    private List<Employe> employes;
}
