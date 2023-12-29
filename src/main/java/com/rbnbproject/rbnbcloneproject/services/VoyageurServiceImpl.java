package com.rbnbproject.rbnbcloneproject.services;

import com.rbnbproject.rbnbcloneproject.dao.VoyageurDao;
import com.rbnbproject.rbnbcloneproject.exceptions.EntityNotFoundException;
import com.rbnbproject.rbnbcloneproject.model.Voyageur;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VoyageurServiceImpl implements VoyageurService{

    private VoyageurDao voyageurDao;
    @Override
    public Voyageur addEntity(Voyageur voyageur) {
        if(voyageur==null)
            throw new EntityNotFoundException("Le voyageur est invalide!!!");
        return this.voyageurDao.save(voyageur);
    }

}
