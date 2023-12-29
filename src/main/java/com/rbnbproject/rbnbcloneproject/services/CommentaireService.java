package com.rbnbproject.rbnbcloneproject.services;

import com.rbnbproject.rbnbcloneproject.model.Commentaire;

public interface CommentaireService extends IMetier<Commentaire,Integer>{
    void addCommentaireToHouse(String houseId,Integer commentId);

}
