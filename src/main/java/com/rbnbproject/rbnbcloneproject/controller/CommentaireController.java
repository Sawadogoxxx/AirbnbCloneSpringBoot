package com.rbnbproject.rbnbcloneproject.controller;
import com.rbnbproject.rbnbcloneproject.controller.api.ApiController;
import com.rbnbproject.rbnbcloneproject.controller.api.AppRoute;
import com.rbnbproject.rbnbcloneproject.exceptions.EntityNotFoundException;
import com.rbnbproject.rbnbcloneproject.model.Commentaire;
import com.rbnbproject.rbnbcloneproject.model.House;
import com.rbnbproject.rbnbcloneproject.services.CommentaireServiceImpl;
import com.rbnbproject.rbnbcloneproject.services.HouseServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppRoute.root+"/comment")
public class CommentaireController implements ApiController<Commentaire,Integer> {

    private final CommentaireServiceImpl commentaireService;
    private HouseServiceImpl houseServicel;

    public CommentaireController(CommentaireServiceImpl commentaireService, HouseServiceImpl houseServicel) {
        this.commentaireService = commentaireService;
        this.houseServicel = houseServicel;
    }

    @PostMapping("/add/{houseId}")
    public ResponseEntity<String> addCommentToHouse(@PathVariable("houseId")String houseId,@RequestBody Commentaire commentaire){
        this.commentaireService.addCommentaireToHouse(houseId,commentaire);
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
    @GetMapping("/all")
    public List<Commentaire> findAll() {
        return this.commentaireService.findAll();
    }
    @Override
    @DeleteMapping("/commentaire/delete/{id}")
    public ResponseEntity<String> deleteEntite(@PathVariable("id") Integer id) {
        this.commentaireService.deleteEntite(id);
        return ResponseEntity.ok().body("Commentaire supprimé avec success!!!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Commentaire> updateEntitie(@RequestBody  Commentaire commentaire, @PathVariable("id") Integer id) {
        if(commentaire==null)throw new EntityNotFoundException("Ce commentaire est invalide!!!");
        Commentaire commentaireUpdated=commentaireService.findEntite(id);
        commentaireUpdated.setMessage(commentaire.getMessage());
        commentaireUpdated.setDateEnvoie(commentaire.getDateEnvoie());

        Commentaire newCommentaire=this.commentaireService.addEntity(commentaireUpdated);
        commentaireUpdated.setHouse(newCommentaire.getHouse());
//
//        House house=this.houseServicel.findEntite(houseId);
//        commentaireUpdated.setHouse(house);
//        house.getCommentaires().add(commentaireUpdated);

        return ResponseEntity.ok().body(commentaireUpdated);
    }
}
