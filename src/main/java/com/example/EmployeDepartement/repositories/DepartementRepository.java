package com.example.EmployeDepartement.repositories;

import com.example.EmployeDepartement.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Department,Long> {
}
