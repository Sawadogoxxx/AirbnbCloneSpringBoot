package com.rbnbproject.rbnbcloneproject.dao;

import com.rbnbproject.rbnbcloneproject.model.Piece;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PieceDao extends JpaRepository<Piece,Integer> {
}
