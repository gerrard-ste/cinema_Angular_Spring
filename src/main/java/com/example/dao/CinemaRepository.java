package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.entities.Cinema;
@RepositoryRestResource
@CrossOrigin("*") // ajouter
public interface CinemaRepository extends JpaRepository<Cinema, Long>{

}
