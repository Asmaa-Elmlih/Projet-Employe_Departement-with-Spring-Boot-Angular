package com.example.EmployeDepartement.utils;

import com.example.EmployeDepartement.models.Employe;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class EmployeSpecifications {
   /* public static Specification<Employe> filtrerParCritere(String critere) {
        //System.out.println("Critère reçu pour le filtrage : " + critere);
        return (Root<Employe> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            // Ajoutez ici vos conditions de filtrage
            Predicate predicate = criteriaBuilder.equal(criteriaBuilder.lower(root.get("nom")), critere.toLowerCase());
            // Vous pouvez ajouter d'autres conditions
            return predicate;
        };
    }*/


    public static Specification<Employe> filtrerParCritere(String nom, String prenom, String cin, String tel) {
        return (Root<Employe> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (nom != null && !nom.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nom")), "%" + nom.toLowerCase() + "%"));
            }
            if (prenom != null && !prenom.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("prenom")), "%" + prenom.toLowerCase() + "%"));
            }
            if (cin != null && !cin.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("cin")), "%" + cin.toLowerCase() + "%"));
            }
            if (tel != null && !tel.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("tel")), "%" + tel.toLowerCase() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
