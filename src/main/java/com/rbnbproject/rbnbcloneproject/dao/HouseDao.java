package com.rbnbproject.rbnbcloneproject.dao;

import com.rbnbproject.rbnbcloneproject.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseDao extends JpaRepository<House,String> {

    House findByNom(String nom);

    List<House>findByPrixNuit(Double prixNuit);
}
