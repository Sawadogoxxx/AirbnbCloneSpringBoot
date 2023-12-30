package com.rbnbproject.rbnbcloneproject.services;

import com.rbnbproject.rbnbcloneproject.dao.CommentaireDao;
import com.rbnbproject.rbnbcloneproject.exceptions.EntityNotFoundException;
import com.rbnbproject.rbnbcloneproject.model.Commentaire;
import com.rbnbproject.rbnbcloneproject.model.House;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class CommentaireServiceImpl implements CommentaireService {

    private final CommentaireDao commentaireDao;
    private HouseServiceImpl houseService;

    public CommentaireServiceImpl(CommentaireDao commentaireDao, HouseServiceImpl houseService) {
        this.commentaireDao = commentaireDao;
        this.houseService = houseService;
    }

    @Override
    public Commentaire addEntity(Commentaire commentaire) {
        if(Objects.isNull(commentaire))
            throw new EntityNotFoundException("Ce commentaire est invalide!!!");
        return this.commentaireDao.save(commentaire);
    }

    @Override
    public Commentaire findEntite(Integer id) {
        return this.commentaireDao.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Ce commentaire est introuvable"));
    }

    @Override
    public List<Commentaire> findAll() {
        return this.commentaireDao.findAll();
    }

    @Override
    public void deleteEntite(Integer id) {
        Commentaire commentaire=this.findEntite(id);
        this.commentaireDao.delete(commentaire);
    }

    @Override
    public void updateEntitie(Commentaire commentaire, Integer integer) {

    }

    @Override
    public void addCommentaireToHouse(String houseId,Commentaire commentaire) {
        House house=this.houseService.findEntite(houseId);
        Commentaire commentaire1=this.commentaireDao.save(commentaire);

        house.getCommentaires().add(commentaire1);
        commentaire.setHouse(house);
    }
}
