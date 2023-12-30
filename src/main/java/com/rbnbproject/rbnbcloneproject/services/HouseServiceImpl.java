package com.rbnbproject.rbnbcloneproject.services;

import com.rbnbproject.rbnbcloneproject.dao.HouseDao;
import com.rbnbproject.rbnbcloneproject.exceptions.EntityNotFoundException;
import com.rbnbproject.rbnbcloneproject.model.Categorie;
import com.rbnbproject.rbnbcloneproject.model.House;
import com.rbnbproject.rbnbcloneproject.model.Piece;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Transactional
@Service
public class HouseServiceImpl implements IMetier<House, String> {

    private final HouseDao houseDao;
    private final CategorieServiceImpl categorieService;
    private final PieceServiceImpl pieceService;

    public HouseServiceImpl(HouseDao houseDao, CategorieServiceImpl categorieService,
                            PieceServiceImpl pieceService) {
        this.houseDao = houseDao;
        this.categorieService = categorieService;
        this.pieceService = pieceService;
    }
    @Override
    public House addEntity(House house) {
        if(Objects.isNull(house))
            throw new EntityNotFoundException("Cette maison est invalide!!!");

        Set<Categorie>categories=house.getCategories();
        categories.forEach(categorie -> {
            Optional<Categorie>optionalCategorie=this.categorieService
                    .findByNomCategorie(categorie.getNomCategorie());
            house.setCategories(new HashSet<>());
            if(optionalCategorie.isEmpty()){
                Categorie newCategorie=new Categorie();
                newCategorie.setNomCategorie(categorie.getNomCategorie());
                Categorie categorieSaved=this.categorieService.addEntity(newCategorie);
                house.getCategories().add(categorieSaved);
            }else{
                Categorie categorie1=optionalCategorie.get();
                house.getCategories().add(categorie1);
            }
        });
        Set<Piece>pieces=house.getPieces();
        pieces.forEach(piece ->{
            Piece pieceSaved=pieceService.addEntity(piece);
            house.getPieces().add(pieceSaved);
        });
        System.err.println(categories);
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
