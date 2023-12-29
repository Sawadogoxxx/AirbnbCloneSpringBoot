package com.rbnbproject.rbnbcloneproject.services;

import com.rbnbproject.rbnbcloneproject.model.ServiceLogement;

public interface ServiceLogementService extends IMetier<ServiceLogement,Integer>{
    void addServiceToHouse(String houseId,Integer id);
}
