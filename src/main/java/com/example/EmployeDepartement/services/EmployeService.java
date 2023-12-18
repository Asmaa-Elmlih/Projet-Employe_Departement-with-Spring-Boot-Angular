package com.example.EmployeDepartement.services;

import com.example.EmployeDepartement.DTO.EmployeDTO;
import com.example.EmployeDepartement.models.Employe;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeService {
    Employe add(Long departement_id, EmployeDTO employeDTO);
    Page<Employe> getAll(String nom,String prenom,String cin,String tel, int page, int size);
    EmployeDTO getById(long id);
    void update(long id,EmployeDTO employeDTO);
    void delete(long id);
}
