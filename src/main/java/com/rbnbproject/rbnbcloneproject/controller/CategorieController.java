package com.rbnbproject.rbnbcloneproject.controller;

import com.rbnbproject.rbnbcloneproject.controller.api.ApiController;
import com.rbnbproject.rbnbcloneproject.controller.api.AppRoute;
import com.rbnbproject.rbnbcloneproject.model.Categorie;
import com.rbnbproject.rbnbcloneproject.model.House;
import com.rbnbproject.rbnbcloneproject.services.CategorieServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = AppRoute.root)
public class CategorieController implements ApiController<Categorie,Integer> {

    private final CategorieServiceImpl categorieService;

    public CategorieController(CategorieServiceImpl categorieService) {
        this.categorieService = categorieService;
    }
    @GetMapping("/categories/houses/{name}")
    public List<House>findHouseByCategories(@PathVariable("name")String nomCategorie){
         return  this.categorieService.findHousesByCategorie(nomCategorie);
    }
    @Override
    @PostMapping("/categorie")
    public ResponseEntity<?> addEntity(@Valid @RequestBody Categorie categorie) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(this.categorieService.addEntity(categorie));
    }
    @PostMapping("/addcategorietoHouse/{house}/{catId}")
    public ResponseEntity<String> addCategorieToHouse(@PathVariable("house")String houseId,@PathVariable("catId")Integer id){
        this.categorieService.addCategorieToHouse(houseId,id);
        return ResponseEntity.ok().body("Catégorie ajouté a la maison avec success");
    }

    @Override
    @GetMapping("/categorie/{id}")
    public ResponseEntity<Categorie> findEntite(Integer id) {
        return ResponseEntity.ok().body(this.categorieService.findEntite(id));
    }
    @Override
    @GetMapping("/categories")
    public List<Categorie> findAll() {
        return this.categorieService.findAll();
    }
    @Override
    @DeleteMapping("/categorie/delete/{id}")
    public ResponseEntity<String> deleteEntite(@PathVariable("id") Integer id) {
        this.categorieService.deleteEntite(id);
        return ResponseEntity.ok().body("Catégorie Supprimé avec success");
    }
    @Override
    public ResponseEntity<Categorie> updateEntitie(Categorie categorie, Integer integer) {
        return null;
    }
}
