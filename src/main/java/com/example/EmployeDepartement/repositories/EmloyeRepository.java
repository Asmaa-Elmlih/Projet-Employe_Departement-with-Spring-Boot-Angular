package com.example.EmployeDepartement.repositories;

import com.example.EmployeDepartement.models.Employe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmloyeRepository extends JpaRepository<Employe,Long> , JpaSpecificationExecutor<Employe> {


    Page<Employe> findAll(Pageable pageable);

}
