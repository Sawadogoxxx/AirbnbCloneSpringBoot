package com.rbnbproject.rbnbcloneproject.controller;

import com.rbnbproject.rbnbcloneproject.controller.api.ApiController;
import com.rbnbproject.rbnbcloneproject.model.Categorie;
import com.rbnbproject.rbnbcloneproject.model.House;
import com.rbnbproject.rbnbcloneproject.services.CategorieServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/categorie")
@RequiredArgsConstructor
public class CategorieController implements ApiController<Categorie,Integer> {

    private final CategorieServiceImpl categorieService;

    @GetMapping("/houses/{name}")
    public List<House>findHouseByCategories(@PathVariable("name")String nomCategorie){
         return  this.categorieService.findHousesByCategorie(nomCategorie);
    }
    @Override
    @PostMapping("/")
    public ResponseEntity<?> addEntity(@Valid @RequestBody Categorie categorie) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(this.categorieService.addEntity(categorie));
    }

    @PostMapping("/addcategorietoHouse/{house}/{catId}")
    public ResponseEntity<String> addCategorieToHouse(@PathVariable("house")String houseId,@PathVariable("catId")Integer id){
        this.categorieService.addCategorieToHouse(houseId,id);
        return ResponseEntity.ok().body("Catégorie ajouté a la maison avec success");
    }
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Categorie> findEntite(Integer id) {
        return ResponseEntity.ok().body(this.categorieService.findEntite(id));
    }
    @Override
    @GetMapping("/all")
    public List<Categorie> findAll() {
        return this.categorieService.findAll();
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEntite(@PathVariable("id") Integer id) {
        this.categorieService.deleteEntite(id);
        return ResponseEntity.ok().body("Catégorie Supprimé avec success");
    }

    @PutMapping("/update/{catId}")
    @Override
    public ResponseEntity<Categorie> updateEntitie(@RequestBody Categorie categorie,@PathVariable("catId")Integer integer) {
        return null;
    }
}
