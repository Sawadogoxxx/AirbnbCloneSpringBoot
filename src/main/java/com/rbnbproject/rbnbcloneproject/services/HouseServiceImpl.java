package com.rbnbproject.rbnbcloneproject.services;

import com.rbnbproject.rbnbcloneproject.dao.HouseDao;
import com.rbnbproject.rbnbcloneproject.exceptions.EntityNotFoundException;
import com.rbnbproject.rbnbcloneproject.model.House;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Transactional
@Service
public class HouseServiceImpl implements IMetier<House, String> {

    private final HouseDao houseDao;

    public HouseServiceImpl(HouseDao houseDao) {
        this.houseDao = houseDao;
    }
    @Override
    public House addEntity(House house) {
        if(Objects.isNull(house))
            throw new EntityNotFoundException("Cette maison est invalide!!!");
        house.setId(UUID.randomUUID().toString());
        return this.houseDao.save(house);
    }
    @Override
    public House findEntite(String id) {
        Optional<House>optionalHouse=this.houseDao.findById(id);
        if(optionalHouse.isEmpty()){
            throw new EntityNotFoundException("Aucune Maison correspond a été trouvé!!!");
        }
        return optionalHouse.get();
    }

    @Override
    public List<House> findAll() {
        return this.houseDao.findAll();
    }

    @Override
    public void deleteEntite(String string) {
       this.houseDao.deleteById(string);
    }

    //Utiliser ModelMapper pour modifier l'Objet
    @Override
    public void updateEntitie(House house, String string) {

    }
}
