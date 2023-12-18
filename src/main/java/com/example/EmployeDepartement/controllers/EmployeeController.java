package com.example.EmployeDepartement.controllers;

import com.example.EmployeDepartement.DTO.DepartementDTO;
import com.example.EmployeDepartement.DTO.EmployeDTO;
import com.example.EmployeDepartement.models.Department;
import com.example.EmployeDepartement.models.Employe;
import com.example.EmployeDepartement.services.DepartementService;
import com.example.EmployeDepartement.services.EmployeService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employe")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
    private final EmployeService service;


    public EmployeeController(EmployeService service) {
        this.service = service;
    }
   /* @GetMapping
    public Page<Employe> getAllEmploye( @RequestParam(value = "nom", required = false) String nom,
                                              @RequestParam(value = "page", defaultValue = "0") int page,
                                              @RequestParam(value = "size", defaultValue = "10") int size){
        return service.getAll(nom, page, size);
    }*/

    // Dans votre contrôleur EmployeeController
   /* @GetMapping
    public Page<Employe> getAllEmploye(@RequestParam(value = "nom", required = false) String nom,
                                       @RequestParam(value = "page", defaultValue = "0") int page,
                                       @RequestParam(value = "size", defaultValue = "10") int size) {
        return service.getAll(nom, page, size);
    }*/

    @GetMapping
    public Page<Employe> getAllEmploye(@RequestParam(value = "nom", required = false) String nom,
                                       @RequestParam(value = "prenom", required = false) String prenom,
                                       @RequestParam(value = "cin", required = false) String cin,
                                       @RequestParam(value = "tel", required = false) String tel,
                                       @RequestParam(value = "page", defaultValue = "0") int page,
                                       @RequestParam(value = "size", defaultValue = "10") int size) {
        return service.getAll(nom, prenom, cin, tel, page, size);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeDTO> getEmploye(@PathVariable Long id){
        EmployeDTO employeDTO=service.getById(id);
        return new ResponseEntity<>(employeDTO,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Employe> createEmploye(@RequestBody EmployeDTO employeDTO,@RequestParam Long departmentId){
       Employe saveEmploye= service.add(departmentId,employeDTO);
        return new ResponseEntity<>(saveEmploye,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmploye(@PathVariable Long id,@RequestBody EmployeDTO employeDTO){
        if(!id.equals(employeDTO.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            service.update(id,employeDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
