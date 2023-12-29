package com.rbnbproject.rbnbcloneproject.services;
import com.rbnbproject.rbnbcloneproject.dao.ServiceLogementDao;
import com.rbnbproject.rbnbcloneproject.exceptions.EntityNotFoundException;
import com.rbnbproject.rbnbcloneproject.model.House;
import com.rbnbproject.rbnbcloneproject.model.Piece;
import com.rbnbproject.rbnbcloneproject.model.ServiceLogement;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ServiceLogementServiceImpl implements ServiceLogementService {
    private final ServiceLogementDao serviceLogementDao;
    private HouseServiceImpl houseService;

    public ServiceLogementServiceImpl(ServiceLogementDao serviceLogementDao, HouseServiceImpl houseService) {
        this.serviceLogementDao = serviceLogementDao;
        this.houseService = houseService;
    }
    @Override
    public ServiceLogement addEntity(ServiceLogement serviceLogement) {
        if(serviceLogement==null)throw new EntityNotFoundException("service est invalide!!,veillez bien le remplir");
        return this.serviceLogementDao.save(serviceLogement);
    }

    @Override
    public ServiceLogement findEntite(Integer id){
        return this.serviceLogementDao.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Ce service est introuvable!!!"));
    }
    @Override
    public List<ServiceLogement> findAll() {
        return this.serviceLogementDao.findAll();
    }
    @Override
    public void deleteEntite(Integer id) {
       ServiceLogement serviceLogement=this.findEntite(id);
       this.serviceLogementDao.delete(serviceLogement);
    }
    @Override
    public void updateEntitie(ServiceLogement serviceLogement, Integer integer) {

    }
    @Override
    public void addServiceToHouse(String houseId, Integer id) {
        House house=this.houseService.findEntite(houseId);
        ServiceLogement serviceLogement=this.serviceLogementDao.findById(id).orElseThrow(
                ()->new EntityNotFoundException("Le service est introuvable!!,veillez renseigner un service logement")
        );
        house.getServiceLogements().add(serviceLogement);
    }
}
