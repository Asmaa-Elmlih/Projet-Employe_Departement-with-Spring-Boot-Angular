package com.example.EmployeDepartement.controllers;

import com.example.EmployeDepartement.DTO.DepartementDTO;
import com.example.EmployeDepartement.DTO.EmployeDTO;
import com.example.EmployeDepartement.services.DepartementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/departement")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartementController {
    private final DepartementService service;

    public DepartementController(DepartementService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DepartementDTO>> getAllDepartement(){
        List<DepartementDTO> departementDTOS=service.getAll();
        return new ResponseEntity<>(departementDTOS, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DepartementDTO> getDepartement(@PathVariable Long id){
        DepartementDTO departementDTO=service.getById(id);
        return new ResponseEntity<>(departementDTO,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> createDepartement(@RequestBody DepartementDTO departementDTO){
        service.add(departementDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDepartement(@PathVariable Long id,@RequestBody DepartementDTO departementDTO){
        if(!id.equals(departementDTO.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            service.update(id,departementDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartement(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

