package com.rbnbproject.rbnbcloneproject.services;
import com.rbnbproject.rbnbcloneproject.model.Piece;

public interface PieceService extends IMetier<Piece,Integer>{
   void addPieceToHouse(String houseId,Integer idPiece);
}
