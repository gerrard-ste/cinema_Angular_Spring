package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.entities.Seance;

@RepositoryRestResource
@CrossOrigin("*") // ajouter
public interface SeanceRepository extends JpaRepository<Seance, Long>{

}
