package com.rbnbproject.rbnbcloneproject.controller;
import com.rbnbproject.rbnbcloneproject.controller.api.ApiController;
import com.rbnbproject.rbnbcloneproject.controller.api.AppRoute;
import com.rbnbproject.rbnbcloneproject.model.Commentaire;
import com.rbnbproject.rbnbcloneproject.services.CommentaireServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppRoute.root)
public class CommentaireController implements ApiController<Commentaire,Integer> {

    private final CommentaireServiceImpl commentaireService;

    public CommentaireController(CommentaireServiceImpl commentaireService) {
        this.commentaireService = commentaireService;
    }

    @PostMapping("/addcommentoHouse/{house}/{commentId}")
    public ResponseEntity<String> addCommentToHouse(@PathVariable("house")String houseId, @PathVariable("commentId")Integer id){
        this.commentaireService.addCommentaireToHouse(houseId,id);
        return ResponseEntity.ok().body("Commentaire ajouté a la maison avec success!!!");
    }
    @Override
    @PostMapping("/commentaire")
    public ResponseEntity<?> addEntity(@Valid  @RequestBody Commentaire commentaire) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.commentaireService.addEntity(commentaire));
    }
    @Override
    @GetMapping("/commentaire/{id}")
    public ResponseEntity<Commentaire> findEntite(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(this.commentaireService.findEntite(id));
    }
    @Override
    @GetMapping("/commentaires")
    public List<Commentaire> findAll() {
        return this.commentaireService.findAll();
    }
    @Override
    @DeleteMapping("/commentaire/delete/{id}")
    public ResponseEntity<String> deleteEntite(@PathVariable("id") Integer id) {
        this.commentaireService.deleteEntite(id);
        return ResponseEntity.ok().body("Commentaire supprimé avec success!!!");
    }
    @Override
    public ResponseEntity<Commentaire> updateEntitie(Commentaire commentaire, Integer integer) {
        return null;
    }
}
