package com.rbnbproject.rbnbcloneproject.services;

import com.rbnbproject.rbnbcloneproject.model.House;

import java.util.List;

public interface HouseService  extends IMetier<House, String>{

    /**
     * Rechercher Une Maison Par son nom
     * @param houseName
     * @return
     */
    House findHouseByName(String houseName);

    /**
     * Rechercher les Maisons ayant un Prix donné
     * @param price
     * @return
     */
    List<House>findHousesByPrice(Double price);

}
