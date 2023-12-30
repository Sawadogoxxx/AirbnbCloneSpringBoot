package com.rbnbproject.rbnbcloneproject.dao;

import com.rbnbproject.rbnbcloneproject.model.Categorie;
import com.rbnbproject.rbnbcloneproject.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CategorieDao extends JpaRepository<Categorie,Integer> {

    @Query(value = "select c.houses from Categorie  c where c.nomCategorie=:vcategorie")
    List<House>findHouseByCategorie(@Param("vcategorie")String catName);

    Optional<Categorie> findByNomCategorie(String nomCategorie);
}
