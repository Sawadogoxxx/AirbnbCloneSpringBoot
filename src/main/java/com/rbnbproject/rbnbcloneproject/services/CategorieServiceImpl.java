package com.rbnbproject.rbnbcloneproject.services;

import com.rbnbproject.rbnbcloneproject.dao.CategorieDao;
import com.rbnbproject.rbnbcloneproject.dao.HouseDao;
import com.rbnbproject.rbnbcloneproject.exceptions.EntityExistException;
import com.rbnbproject.rbnbcloneproject.exceptions.EntityNotFoundException;
import com.rbnbproject.rbnbcloneproject.model.Categorie;
import com.rbnbproject.rbnbcloneproject.model.House;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Transactional
@Service
public class CategorieServiceImpl implements IMetier<Categorie,Integer>, CategorieService{

    private final CategorieDao categorieDao;
    private final HouseDao houseDao;

    public CategorieServiceImpl(CategorieDao categorieDao, HouseDao houseDao) {
        this.categorieDao = categorieDao;
        this.houseDao = houseDao;
    }

    @Override
    public Categorie addEntity(Categorie categorie) {
        if(Objects.isNull(categorie))
            throw new EntityNotFoundException("Cette catégorie est invalide");
        return this.categorieDao.save(categorie);
    }

    @Override
    public Categorie findEntite(Integer id) {
        return this.categorieDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Cette Categorie est introuvable"));
    }
    @Override
    public List<Categorie> findAll() {
        return this.categorieDao.findAll();
    }

    @Override
    public void deleteEntite(Integer id) {
        Categorie categorie=this.findEntite(id);
        this.categorieDao.delete(categorie);
    }

    @Override
    public void updateEntitie(Categorie categorie, Integer integer) {

    }

    @Override
    public void addCategorieToHouse(String houseId, Integer catId) {
        House house=this.houseDao.findById(houseId)
                .orElseThrow(()->new EntityNotFoundException("Cette maison est introuvable!!!"));
        Categorie categorie=this.categorieDao.findById(catId)
                .orElseThrow(()->new EntityNotFoundException("La catégorie est invalide!!!"));

       List<Categorie>categories=house.getCategories().stream().filter(
                categorie1 ->categorie1.getNomCategorie().equals(categorie.getNomCategorie())
        ).toList();

        if(!categories.isEmpty())throw new EntityExistException("Cette Catégorie existe déjà");
        house.getCategories().add(categorie);
        categorie.getHouses().add(house);
    }
}
