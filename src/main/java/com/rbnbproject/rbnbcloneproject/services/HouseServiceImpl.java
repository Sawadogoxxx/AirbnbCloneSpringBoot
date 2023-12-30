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
        if(Objects.isNull(house)) throw new EntityNotFoundException("Cette maison est invalide!!!");
        //Recupération de la liste des Catégories de la maison a Enregistrer
        Set<Categorie>categories=house.getCategories();
        //On parours Chaque Catégorie si La Catégorie n'existe pas dans Notre Liste de Catégorie en base de donnée
        //Alors on crée Une Nouvelle Catégorie
        //Sion on l'affecte A la Maison dans Le cas ou la Catégorie Existe  dans Notre base de donnée
        categories.forEach(categorie -> {
            //Recherche de la catégorie dans Notre base de donnée
            Optional<Categorie>optionalCategorie=this.categorieService.findByNomCategorie(categorie.getNomCategorie());
            house.setCategories(new HashSet<>());//intilisatiion de la liste des Catégories
            if(optionalCategorie.isEmpty()){
                //Si Il n'existe oas Alors il s'agit d"une Nouvcelle Catégorie
                Categorie newCategorie=new Categorie();
                newCategorie.setNomCategorie(categorie.getNomCategorie());
                Categorie categorieSaved=this.categorieService.addEntity(newCategorie);
                house.getCategories().add(categorieSaved);
            }else{
                //Sinon cette Catégorie existe ,On l"affecte a Notre Maison
                Categorie categorie1=optionalCategorie.get();
                house.getCategories().add(categorie1);
            }
        });
        Set<Piece>pieces=house.getPieces();
        pieces.forEach(piece ->{
            Piece pieceSaved=pieceService.addEntity(piece);
            house.getPieces().add(pieceSaved);
        });
        house.setId(UUID.randomUUID().toString());
        return this.houseDao.save(house);
    }
    @Override
    public House findEntite(String id) {
        Optional<House>optionalHouse=this.houseDao.findById(id);
        log.info("Maison:  "+optionalHouse.get());
        if(optionalHouse.isEmpty())throw new EntityNotFoundException("Aucune Maison correspondante a été trouvé!!!");
        return optionalHouse.get();
    }

    @Override
    public List<House> findAll() {
        return this.houseDao.findAll();
    }

    //Suppression d'une Maison
    @Override
    public void deleteEntite(String id) {
        House house=this.findEntite(id);
        this.houseDao.delete(house);
    }

    //Utiliser ModelMapper pour modifier l'Objet
    @Override
    public void updateEntitie(House house, String string) {

    }
}
