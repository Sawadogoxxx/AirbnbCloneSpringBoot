package com.rbnbproject.rbnbcloneproject.controller;

import com.rbnbproject.rbnbcloneproject.controller.api.ApiController;
import com.rbnbproject.rbnbcloneproject.controller.api.AppRoute;
import com.rbnbproject.rbnbcloneproject.model.Reservation;
import com.rbnbproject.rbnbcloneproject.services.ReservationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/reservation")
@RequiredArgsConstructor
public class ReservationController implements ApiController<Reservation,String> {

    private final ReservationServiceImpl reservationService;


    @PostMapping("/reservation/{houseId}")
    public ResponseEntity<?> addEntity(@RequestBody Reservation reservation,@PathVariable("houseId")String houseId) {
        Reservation reservation1=this.reservationService.saveReservation(reservation,houseId);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservation1);
    }

    @Override
    public ResponseEntity<?> addEntity(Reservation entity) {
        return null;
    }

    @Override
    public ResponseEntity<Reservation> findEntite(String s) {
        return null;
    }

    @Override
    @GetMapping("/reservations")
    public List<Reservation> findAll() {
        return this.reservationService.findAll();
    }

    @Override
    public ResponseEntity<String> deleteEntite(String s) {
        return null;
    }

    @Override
    public ResponseEntity<Reservation> updateEntitie(Reservation reservation, String s) {
        return null;
    }
}
