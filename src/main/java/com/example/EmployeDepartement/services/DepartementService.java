package com.example.EmployeDepartement.services;

import com.example.EmployeDepartement.DTO.DepartementDTO;
import com.example.EmployeDepartement.DTO.EmployeDTO;
import com.example.EmployeDepartement.models.Department;
import com.example.EmployeDepartement.models.Employe;

import java.util.List;

public interface DepartementService {
    Department add(DepartementDTO departementDTO);
    List<DepartementDTO> getAll();
    DepartementDTO getById(long id);
    void update(long id,DepartementDTO departementDTO);
    void delete(long id);
}
