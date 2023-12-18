package com.example.EmployeDepartement.services.impl;

import com.example.EmployeDepartement.DTO.DepartementDTO;
import com.example.EmployeDepartement.models.Department;
import com.example.EmployeDepartement.repositories.DepartementRepository;
import com.example.EmployeDepartement.services.DepartementService;
import com.example.EmployeDepartement.utils.IMapper;
import com.example.EmployeDepartement.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementServiceImpl implements DepartementService {
    private final DepartementRepository repository;
    private Mapper mapper;

    public DepartementServiceImpl(DepartementRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Department add(DepartementDTO departementDTO) {
        return mapper.map(repository.save(mapper.map(departementDTO, Department.class)),Department.class);
    }

    @Override
    public List<DepartementDTO> getAll() {
        return mapper.mapList(repository.findAll(),DepartementDTO.class);
    }

    @Override
    public DepartementDTO getById(long id) {
        Department department=repository.findById(id).get();
        return mapper.map(department,DepartementDTO.class);
    }

    @Override
    public void update(long id, DepartementDTO departementDTO) {
        Optional<Department> departmentOptional=repository.findById(id);
        if(departmentOptional.isPresent()){
            Department department=departmentOptional.get();
            department.setLibelle(departementDTO.getLibelle());
            department.setDescription(departementDTO.getDescription());
            repository.save(department);
        }
    }

    @Override
    public void delete(long id) {
        Optional<Department> departmentOptional=repository.findById(id);
        if(departmentOptional.isPresent()){
            repository.deleteById(id);
        }
    }
}
