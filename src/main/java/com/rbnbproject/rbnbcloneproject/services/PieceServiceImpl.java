package com.rbnbproject.rbnbcloneproject.services;

import com.rbnbproject.rbnbcloneproject.dao.PieceDao;
import com.rbnbproject.rbnbcloneproject.exceptions.EntityNotFoundException;
import com.rbnbproject.rbnbcloneproject.model.House;
import com.rbnbproject.rbnbcloneproject.model.Piece;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PieceServiceImpl implements PieceService {

    private PieceDao pieceDao;


    public PieceServiceImpl(PieceDao pieceDao) {
        this.pieceDao = pieceDao;
    }

    @Override
    public Piece addEntity(Piece piece) {
        if(piece==null)
            throw new EntityNotFoundException("Cette piece est invalide!!!");
        return this.pieceDao.save(piece);
    }

    @Override
    public Piece findEntite(Integer id) {
        return this.pieceDao.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Cette pièce est introuvable!!!"));
    }

    @Override
    public List<Piece> findAll() {
        return this.pieceDao.findAll();
    }

    @Override
    public void deleteEntite(Integer id) {
        Piece piece=this.findEntite(id);
        this.pieceDao.delete(piece);
    }

    @Override
    public void updateEntitie(Piece piece, Integer integer) {

    }


}
