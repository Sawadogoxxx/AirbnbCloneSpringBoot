package com.rbnbproject.rbnbcloneproject.services;

import com.rbnbproject.rbnbcloneproject.model.Commentaire;

public interface CommentaireService extends IMetier<Commentaire,Integer>{
    public void addCommentaireToHouse(String houseId,Commentaire commentaire);

}
