package com.rbnbproject.rbnbcloneproject.controller;

import com.rbnbproject.rbnbcloneproject.controller.api.ApiController;
import com.rbnbproject.rbnbcloneproject.exceptions.EntityNotFoundException;
import com.rbnbproject.rbnbcloneproject.model.House;
import com.rbnbproject.rbnbcloneproject.services.HouseServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/house")
@RequiredArgsConstructor
public class HouseController implements ApiController<House,String> {

    private final HouseServiceImpl houseService;

    @PostMapping("/add")
    @Override
    public ResponseEntity<?> addEntity(@Valid @RequestBody House house) {
        try {
            House vhouse=this.houseService.addEntity(house);
            return ResponseEntity.status(HttpStatus.CREATED).body(vhouse);
        }catch (EntityNotFoundException e){
           return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    /**
     * Rechercher une Maison par Son Nom
     * @param houseName
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<House>findHouseByName(@RequestParam("name")String houseName){
        log.info("valeur de nom de la maison a rechercher:  "+houseName);
        return ResponseEntity.ok().body(this.houseService.findHouseByName(houseName));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<House> findEntite(@PathVariable("id") String houseId) {
        log.info("Valeur du paramètre  passsé est:  "+houseId);
        House house=this.houseService.findEntite(houseId);
        return ResponseEntity.ok().body(house);
    }

    @GetMapping("/all")
    @Override
    public List<House> findAll() {
        return this.houseService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<String> deleteEntite(@PathVariable("id")String id) {
        this.houseService.deleteEntite(id);
        return ResponseEntity.ok().body("Maison supprimé avec success!!!");
    }
    @Override
    public ResponseEntity<House> updateEntitie(House house, String s) {
        return null;
    }
}
