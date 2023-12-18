package com.example.EmployeDepartement.services.impl;

import com.example.EmployeDepartement.DTO.EmployeDTO;
import com.example.EmployeDepartement.models.Department;
import com.example.EmployeDepartement.models.Employe;
import com.example.EmployeDepartement.repositories.DepartementRepository;
import com.example.EmployeDepartement.repositories.EmloyeRepository;
import com.example.EmployeDepartement.services.EmployeService;
import com.example.EmployeDepartement.utils.EmployeSpecifications;
import com.example.EmployeDepartement.utils.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

@Service
public class EmployeServiceImpl implements EmployeService {

    private final EmloyeRepository repository;
    private final DepartementRepository repositoryD;

    private Mapper mapper;

    public EmployeServiceImpl(EmloyeRepository repository, DepartementRepository repositoryD, Mapper mapper) {
        this.repository = repository;
        this.repositoryD = repositoryD;
        this.mapper = mapper;
    }

    @Override
    public Employe add(Long departement_id,EmployeDTO employeDTO) {
        try {
            Optional<Department> department = repositoryD.findById(departement_id);
            if (department.isPresent()) {
                Department department1 = department.get();
                employeDTO.setDepartement(department1);
                //return repository.save(employeDTO);
                return mapper.map(repository.save(mapper.map(employeDTO,Employe.class)),Employe.class);
            } else {
                throw new IllegalArgumentException("Le département avec l'ID spécifié n'existe pas");
            }
        } catch (IllegalArgumentException ex) {
            // Loggez l'erreur pour le suivi
            // logger.error("Erreur lors de l'ajout de l'employé : " + ex.getMessage());

            // Gérez l'exception en renvoyant un message ou en relançant l'exception
            throw new IllegalArgumentException("Erreur lors de l'ajout de l'employé : " + ex.getMessage());
        }
    }
        //return mapper.map(repository.save(mapper.map(employeDTO,Employe.class)),Employe.class);




/*    public Page<Employe> getAll(String nom, int page, int size) {
        if (nom != null && !nom.isEmpty()) {
            Specification<Employe> spec = EmployeSpecifications.filtrerParCritere(nom);
            Pageable pageable = PageRequest.of(page, size);
            return repository.findAll(spec, pageable);
        } else {
            Pageable pageable = PageRequest.of(page, size);
            return repository.findAll(pageable);
        }
    }*/

    public Page<Employe> getAll(String nom, String prenom, String cin, String tel, int page, int size) {
        Specification<Employe> spec = EmployeSpecifications.filtrerParCritere(nom, prenom, cin, tel);

        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(spec, pageable);
    }




    @Override
    public EmployeDTO getById(long id) {
        Employe employe=repository.findById(id).get();
        return mapper.map(employe,EmployeDTO.class);
    }

    @Override
    public void update(long id, EmployeDTO employeDTO) {
        Optional<Employe> employeOptional=repository.findById(id);
        if(employeOptional.isPresent()){
            Employe employe=employeOptional.get();
            employe.setNom(employeDTO.getNom());
            employe.setPrenom(employeDTO.getPrenom());
            employe.setCin(employeDTO.getCin());
            employe.setTel(employeDTO.getTel());
            repository.save(employe);
        }
    }

    @Override
    public void delete(long id) {
        Optional<Employe> employeOptional=repository.findById(id);
        if(employeOptional.isPresent()){
            repository.deleteById(id);
        }
    }
}
