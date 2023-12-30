package com.rbnbproject.rbnbcloneproject.services;

import com.rbnbproject.rbnbcloneproject.model.Categorie;
import com.rbnbproject.rbnbcloneproject.model.House;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CategorieService {

    /**
     * Ajouter Une Catégorie a une Maison
     * @param houseId
     * @param catId
     */
    void addCategorieToHouse(String houseId,Integer catId);

    /**
     * Rechercher des Logements Par Catégorie
     * @param catName
     * @return
     */
    List<House>findHousesByCategorie(String catName);

    /**
     *
     * @param nomCategorie
     * @return
     */
    Optional<Categorie> findByNomCategorie(String nomCategorie);



}
