package com.rbnbproject.rbnbcloneproject.controller;

import com.rbnbproject.rbnbcloneproject.controller.api.ApiController;
import com.rbnbproject.rbnbcloneproject.controller.api.AppRoute;
import com.rbnbproject.rbnbcloneproject.model.Piece;
import com.rbnbproject.rbnbcloneproject.services.PieceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = AppRoute.root)
public class PieceController implements ApiController<Piece,Integer> {

    private final PieceServiceImpl pieceService;

    public PieceController(PieceServiceImpl pieceService) {
        this.pieceService = pieceService;
    }


    @Override
    @PostMapping("/piece")
    public ResponseEntity<?> addEntity(@RequestBody Piece piece) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.pieceService.addEntity(piece));
    }

    @Override
    @GetMapping("/piece/{id}")
    public ResponseEntity<Piece> findEntite(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(this.pieceService.findEntite(id));
    }

    @Override
    @GetMapping("/pieces")
    public List<Piece> findAll() {
        return this.pieceService.findAll();
    }

    @Override
    @DeleteMapping("/piece/delete/{id}")
    public ResponseEntity<String> deleteEntite(@PathVariable("id") Integer id){
        this.pieceService.deleteEntite(id);
        return ResponseEntity.ok().body("Piece supprimé avec success!!!");
    }

    @Override
    public ResponseEntity<Piece> updateEntitie(Piece piece, Integer integer) {
        return null;
    }
}
