package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.entities.*;
@RepositoryRestResource

public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
