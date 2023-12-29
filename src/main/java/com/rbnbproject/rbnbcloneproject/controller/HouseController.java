package com.rbnbproject.rbnbcloneproject.controller;

import com.rbnbproject.rbnbcloneproject.controller.api.ApiController;
import com.rbnbproject.rbnbcloneproject.controller.api.AppRoute;
import com.rbnbproject.rbnbcloneproject.exceptions.EntityNotFoundException;
import com.rbnbproject.rbnbcloneproject.model.House;
import com.rbnbproject.rbnbcloneproject.services.HouseServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(AppRoute.root)
public class HouseController implements ApiController<House,String> {

    private final HouseServiceImpl houseService;

    public HouseController(HouseServiceImpl houseService) {
        this.houseService = houseService;
    }

    @PostMapping("/addHouse")
    @Override
    public ResponseEntity<?> addEntity(@Valid @RequestBody House house) {
        try {
            House vhouse=this.houseService.addEntity(house);
            return ResponseEntity.status(HttpStatus.CREATED).body(vhouse);
        }catch (EntityNotFoundException e){
           return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/getHouse/{id}")
    @Override
    public ResponseEntity<House> findEntite(@PathVariable("id") String s) {
        House house=this.houseService.findEntite(s);
        return ResponseEntity.ok().body(house);
    }

    @GetMapping("/houses")
    @Override
    public List<House> findAll() {
        return this.houseService.findAll();
    }

    @DeleteMapping("/deleteHouse/{id}")
    @Override
    public ResponseEntity<String> deleteEntite(@PathVariable("id") String s) {
        this.houseService.deleteEntite(s);
        return ResponseEntity.ok().body("Maison supprimé avec success!!!");
    }

    @Override
    public ResponseEntity<House> updateEntitie(House house, String s) {
        return null;
    }
}
