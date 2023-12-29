package com.rbnbproject.rbnbcloneproject.dao;

import com.rbnbproject.rbnbcloneproject.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireDao extends JpaRepository<Commentaire,Integer> {
}
